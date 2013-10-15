package br.com.exemplo.vendas.util.exception;


/**
 * Respons�vel por lan�ar a exce��o SysException
 *
 * @version 1.0
 */
public abstract class SysException extends LayerException
{

	/**
	 * M�todo construtor para SysException
	 */
   	public SysException()
   	{
 		super();
 	}

	/**
	 * M�todo construtor para SysException
	 */
   	public SysException(MsgException msg)
   	{
   		super(msg);
 	}

	/**
	 * M�todo construtor para SysException
	 */
 	public SysException(MsgExceptionList list)
 	{
 		super(list);
 	}
}
