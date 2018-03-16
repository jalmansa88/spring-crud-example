package es.wata.jalmansa.springuebung.exceptions;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 4330076778983700200L;

	private Integer exceptionCode;
	
	public ServiceException(Integer exceptionCode) {
		super();
		this.exceptionCode = exceptionCode;
	}
	
	public ServiceException(Integer exceptionCode, String message) {
		super(message);
		this.exceptionCode = exceptionCode;
	}

	public Integer getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(Integer exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

}
