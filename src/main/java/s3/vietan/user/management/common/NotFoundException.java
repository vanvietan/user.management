package s3.vietan.user.management.common;

public class NotFoundException extends RuntimeException{
	
	public NotFoundException() {
		super();
	}
	public NotFoundException(String message) {
		super(message);
	}
}
