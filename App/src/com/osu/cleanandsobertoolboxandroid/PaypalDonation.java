package com.osu.cleanandsobertoolboxandroid;

import java.math.BigDecimal;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

public class PaypalDonation extends Activity {
	
    
	// note that these credentials will differ between live & sandbox environments.
    private static final String CONFIG_CLIENT_ID ="AXputRBJLZnwcRnuIXkjgLde3hWk_DeC54PlR2X11TxcWeF0MY6AcA4NP7R6";
    
    private static final String CONFIG_RECEIVER_EMAIL = "cleanandsobertoolbox-facilitator@gmail.com";
    
    private EditText donationAmt;
    
    private static PayPalConfiguration config = new PayPalConfiguration()

    // Start with mock environment.  When ready, switch to sandbox (ENVIRONMENT_SANDBOX)
    // or live (ENVIRONMENT_PRODUCTION)
    .environment(PayPalConfiguration.ENVIRONMENT_PRODUCTION)

    .clientId(CONFIG_CLIENT_ID);
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_paypal_donation);
		
		donationAmt = (EditText)findViewById(R.id.donationAmt);
		
		Intent intent = new Intent(this, PayPalService.class);

		intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
	    startService(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.paypal_donation, menu);
		return true;
	}

	@Override
	public void onDestroy() {
	    stopService(new Intent(this, PayPalService.class));
	    super.onDestroy();
	}
	
	public void onBuyPressed(View pressed) {
		String amount = donationAmt.getText().toString();
		if(!amount.equals("") && !amount.equals(".")){
			//Toast.makeText(this,  amount + " selected", Toast.LENGTH_LONG).show();
			//float amt = (float)Float.valueOf(amount);
			float amt = Float.parseFloat(amount);
			if(amt == Float.NaN) {
				Toast.makeText(this,  "Please enter a valid number", Toast.LENGTH_LONG).show();
			}else if (amt < 1) {
				Toast.makeText(this,  "Please donate atleast $1.00", Toast.LENGTH_LONG).show();
			} else{
			    PayPalPayment payment = new PayPalPayment(new BigDecimal(amount), "USD", "Donate",PayPalPayment.PAYMENT_INTENT_SALE);
		
			    Intent intent = new Intent(this, PaymentActivity.class);
		
			    intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);
		
			    startActivityForResult(intent, 0);
			}
		}
	}
	
	@Override
	protected void onActivityResult (int requestCode, int resultCode, Intent data) {
	    if (resultCode == Activity.RESULT_OK) {
	        PaymentConfirmation confirm = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
	        if (confirm != null) {
	            try {
	            	
	                Log.i("paymentExample", confirm.toJSONObject().toString(4));
	                //Toast.makeText(this,  confirm.toJSONObject().toString(4), Toast.LENGTH_LONG).show();
	                JSONTokener tokener = new JSONTokener(confirm.toJSONObject().toString(4));
	                JSONObject root = new JSONObject(tokener);
	                
	                String response_result = root.getString("response");
	                //Toast.makeText(this,  proof_of_payment_result, Toast.LENGTH_LONG).show();
	                Log.i("proof", response_result);
	                
	                JSONTokener proof_of_payment_tokener = new JSONTokener(response_result);
	                JSONObject proof_of_payment_root = new JSONObject(proof_of_payment_tokener);
	                
	                String state_result = proof_of_payment_root.getString("state");
	                //Toast.makeText(this,  rest_api_result, Toast.LENGTH_LONG).show();
	                Log.i("proof", state_result);
	                
	                
	                Toast.makeText(this, "Your Transaction is " + state_result, Toast.LENGTH_LONG).show();
	                Log.i("proof", state_result);
	                // TODO: send 'confirm' to your server for verification.
	                // see https://developer.paypal.com/webapps/developer/docs/integration/mobile/verify-mobile-payment/
	                // for more details.

	            } catch (JSONException e) {
	                Log.e("paymentExample", "an extremely unlikely failure occurred: ", e);
	            }
	        }
	    }
	    else if (resultCode == Activity.RESULT_CANCELED) {
	        Log.i("paymentExample", "The user canceled.");
	    }
	    else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
	        Log.i("paymentExample", "An invalid payment was submitted. Please see the docs.");
	    }
	}
}
