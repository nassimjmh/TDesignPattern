package commande.water.command;

public abstract class AbstractCommand implements Command {

	protected int decantedVolume;

	public int getDecantedVolume() {
		return decantedVolume;
	}

	public void setDecantedVolume(int decantedVolume) {
		this.decantedVolume = decantedVolume;
	}
}
