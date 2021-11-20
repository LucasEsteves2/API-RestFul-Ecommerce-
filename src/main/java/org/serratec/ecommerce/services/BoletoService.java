package org.serratec.ecommerce.services;

import java.util.Calendar;
import java.util.Date;

import org.serratec.ecommerce.entity.PagamentoComBoleto;
import org.springframework.stereotype.Service;

@Service
public class BoletoService {

	public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date data)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.DAY_OF_MONTH,7);
		pagto.setDataVencimento(cal.getTime());
	}
}
