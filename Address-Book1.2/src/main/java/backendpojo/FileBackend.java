package backendpojo;

import backend.Backend;

public class FileBackend implements Backend {
	
	String path;
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return path;
		
	}
}
