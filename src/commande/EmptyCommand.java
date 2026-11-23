package commande;


public class EmptyCommand extends AbstractCommand {

	private Can can;
	
	public EmptyCommand(Can b) {
		this.can = b;
	}
	
	@Override
	public void execute() {
		setDecantedVolume(can.getVolume());
		can.empty();

	}

	@Override
	public void cancel() {
		can.setVolume(getDecantedVolume());
	}
	
	@Override
	public String toString() {
		return "Vider le " + can;
	}

}
