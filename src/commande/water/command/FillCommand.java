package commande.water.command;

import commande.water.Can;

public class FillCommand extends AbstractCommand {

	private Can can;

	public FillCommand(Can can) {
		this.can = can;
	}

	@Override
	public void execute() {
		setDecantedVolume(can.getMaxVolume() - can.getVolume());
		can.fill();
	}

	@Override
	public void cancel() {
		can.setVolume(can.getVolume() - getDecantedVolume());
	}
	
	@Override
	public String toString() {
		return "Remplir à ras bord le " + can;
	}

}
