package decaf.error;

import decaf.Location;

/**
 * example：function 'gotoMars' expects 1 argument(s) but 3 given<br>
 * PA2
 */
public class PrintError extends DecafError {

	private String method;

	public PrintError(Location location, String method) {
		super(location);
		this.method = method;
	}

	@Override
	protected String getErrMsg() {
		return method;
	}
}
