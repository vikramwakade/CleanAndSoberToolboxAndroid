package com.osu.cleanandsobertoolboxandroid;

import java.math.BigDecimal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

public class PaypalDonation extends Activity {
	
	// set to PaymentActivity.ENVIRONMENT_PRODUCTION to move real money.
    // set to PaymentActivity.ENVIRONMENT_SANDBOX to use your test credentials from https://developer.paypal.com
    // set to PaymentActivity.ENVIRONMENT_NO_NETWORK to kick the tires without communicating to PayPal's servers.
    private static final String CONFIG_ENVIRONMENT = PaymentActivity.ENVIRONMENT_NO_NETWORK;
    
	// note that these credentials will differ between live & sandbox environments.
    private static final String CONFIG_CLIENT_ID = "AbsS7xCV4p_NtQnEUs07SSxR8sz5g2ad7HT9Sbwi7AQh4UHD4QnqE8yXs3fK"; //"credential-from-developer.paypal.com"
    
    private static final String RECEIVER_EMAIL = "cleanandsobertoolbox-facilitator@gmail.com";
    
    private EditText donationAmt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_paypal_donation);
		
		donationAmt = (EditText)findViewById(R.id.donationAmt);
		
		Intent intent = new Intent(this, PayPalService.class);

	    // live: don't put any environment extra
	    // sandbox: use PaymentActivity.ENVIRONMENT_SANDBOX
	    intent.putExtra(PaymentActivity.EXTRA_PAYPAL_ENVIRONMENT, CONFIG_ENVIRONMENT);

	    intent.putExtra(PaymentActivity.EXTRA_CLIENT_ID, CONFIG_CLIENT_ID);

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
		if(!amount.equals("")){
			Toast.makeText(this,  amount + " selected", Toast.LENGTH_LONG).show();
			float amt = (float)Float.valueOf(amount);
			if (amt < 1) {
				Toast.makeText(this,  "Please donate atleast $1.00", Toast.LENGTH_LONG).show();
			} else{
			    PayPalPayment payment = new PayPalPayment(new BigDecimal(amount), "USD", "Donate");
		
			    Intent intent = new Intent(this, PaymentActivity.class);
		
			    // comment this line out for live or set to PaymentActivity.ENVIRONMENT_SANDBOX for sandbox
			    intent.putExtra(PaymentActivity.EXTRA_PAYPAL_ENVIRONMENT, CONFIG_ENVIRONMENT);
		
			    // it's important to repeat the clientId here so that the SDK has it if Android restarts your
			    // app midway through the payment UI flow.
			    intent.putExtra(PaymentActivity.EXTRA_CLIENT_ID, CONFIG_CLIENT_ID);
		
			    // Provide a payerId that uniquely identifies a user within the scope of your system,
			    // such as an email address or user ID.
			    final TelephonyManager tm =(TelephonyManager)getBaseContext().getSystemService(Context.TELEPHONY_SERVICE);

			    String deviceid = tm.getDeviceId();
			    intent.putExtra(PaymentActivity.EXTRA_PAYER_ID, deviceid);//"<someuser@somedomain.com>");
		
			    intent.putExtra(PaymentActivity.EXTRA_RECEIVER_EMAIL, RECEIVER_EMAIL);
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
	                
	                String proof_of_payment_result = root.getString("proof_of_payment");
	                //Toast.makeText(this,  proof_of_payment_result, Toast.LENGTH_LONG).show();
	                Log.i("proof", proof_of_payment_result);
	                
	                JSONTokener proof_of_payment_tokener = new JSONTokener(proof_of_payment_result);
	                JSONObject proof_of_payment_root = new JSONObject(proof_of_payment_tokener);
	                
	                String rest_api_result = proof_of_payment_root.getString("rest_api");
	                //Toast.makeText(this,  rest_api_result, Toast.LENGTH_LONG).show();
	                Log.i("proof", rest_api_result);
	                
	                
	                JSONTokener final_tokener = new JSONTokener(rest_api_result);
	                JSONObject final_root = new JSONObject(final_tokener);
	                
	                String result = final_root.getString("state");
	                Toast.makeText(this, "Your Transaction is " + result, Toast.LENGTH_LONG).show();
	                Log.i("proof", result);
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
	    else if (resultCode == PaymentActivity.RESULT_PAYMENT_INVALID) {
	        Log.i("paymentExample", "An invalid payment was submitted. Please see the docs.");
	    }
	}
}
