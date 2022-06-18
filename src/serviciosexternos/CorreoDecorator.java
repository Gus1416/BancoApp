package serviciosexternos;

/**
 *
 * @author Gustavo
 */
public abstract class CorreoDecorator implements ICorreo{
	protected ICorreo decoratedCorreo;
	
	public CorreoDecorator(ICorreo pDecoratedCorreo){
		decoratedCorreo = pDecoratedCorreo;
	}
	
	@Override
	public void enviarCorreo(String pCorreoElectronico){
		decoratedCorreo.enviarCorreo(pCorreoElectronico);
	}
	
	@Override
	public void setMensaje(String pMensaje){
		decoratedCorreo.setMensaje(pMensaje);
	}
	
	@Override
	public String getMensaje(){
		return decoratedCorreo.getMensaje();
	}
}
