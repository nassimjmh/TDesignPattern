package commande.water.command;

import commande.water.Can;

public class DecantCommand extends AbstractCommand {

	private Can src, dest;

	public DecantCommand(Can src, Can dst) {
		this.src = src;
		this.dest = dst;
	}

	@Override
	public void execute() {
		setDecantedVolume(src.decant(dest));
	}

	@Override
	public void cancel() {
		src.setVolume(src.getVolume() + getDecantedVolume());
		dest.setVolume(dest.getVolume() - getDecantedVolume());
	}
	
	@Override
	public String toString() {
		return "Transvaser le " + src + " dans le " + dest;
	}

}
