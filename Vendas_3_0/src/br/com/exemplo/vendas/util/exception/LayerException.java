package br.com.exemplo.vendas.util.exception;


/**
 * Respons�vel por lan�ar a exce��o LayerException
 *
 * @version 1.0
 */
public abstract class LayerException extends Exception
{

	private MsgExceptionList msgExceptionList;

	/**
	 * M�todo construtor para LayerException
	 */
 	public LayerException()
 	{
 		super();
 	}

	/**
	 * M�todo construtor para LayerException
	 */
 	public LayerException(MsgException msg)
 	{
 		super();
 		this.msgExceptionList = new MsgExceptionList(msg);
 	}

	/**
	 * M�todo construtor para LayerException
	 */
 	public LayerException(MsgExceptionList msgExceptionList)
 	{
 		super();
 		this.msgExceptionList = msgExceptionList;
 	}


	/**
	 * M�todo utilizado para recuperar uma MsgExceptionList.
	 * @return 	MsgExceptionList
	 * @see 	MsgExceptionList
	 */
	public MsgExceptionList getMsgExceptionList()
	{
		return msgExceptionList;
	}

	/**
	 * M�todo utilizado para configurar uma MsgExceptionList.
	 * @param 	list 				informa um arrayList de MsgExceptionList
	 * @see 	MsgExceptionList
	 */
	public void setMsgExceptionList(MsgExceptionList list)
	{
		this.msgExceptionList = list ;
	}
}
