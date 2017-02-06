package in.co.zoeb.vpntree;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutAppFragment extends Fragment {

    private View view;

    public AboutAppFragment() {
        // Required empty public constructor
    }

    private void renderWebView() {
        String YourHtmlPage = "<html>\n" +
                "  <head>\n" +
                "    <title>VPNTree: About App</title>\n" +
                "  </head> \n" +
                "  <body style=\"margin:10px;\">\n" +
                "<h3 style=\"text-align: center;\"><span style=\"color: #999999;\">VPNTree allows you to safely and anonymously connect to any network and access any app or site anywhere for free.</span></h3>\n" +
                "<h3 style=\"text-align: center;\"><span style=\"color: #999999;\">Anytime you use the web on your phone, VPNTree first redirects your data to a secure network before transmission. We also hide your IP address so your location is un detectable. Whether you want to unblock YouTube or use as a shield proxy when surfing, your data, identity, and location are secure.</span></h3>\n" +
                "<h3 style=\"text-align: center;\"><span style=\"color: #999999;\">This service is completely free for you.</span></h3>\n" +
                "<h4>&nbsp;</h4>\n" +
                "<h4><span style=\"color: #999999;\">Features:</span></h4>\n" +
                "<h4><span style=\"color: #999999;\">No Premium and No Ads</span></h4>\n" +
                "<h4><span style=\"color: #999999;\">We don't sell VPN, Its free and always be. </span></h4>\n" +
                "<h4><span style=\"color: #999999;\">No Logging </span></h4>\n" +
                "<h4><span style=\"color: #999999;\">All our servers are hosted in off-shore locations where logging user traffic is not required by any local laws. </span></h4>\n" +
                "<h4><span style=\"color: #999999;\">Strong Encryption </span></h4>\n" +
                "<h4><span style=\"color: #999999;\">Even after combining all the world&rsquo;s super-computers together, it would take millions of years to crack AES encryption.</span></h4>\n" +
                "<h4><span style=\"color: #999999;\">P2P Allowed </span></h4>\n" +
                "<h4><span style=\"color: #999999;\">Download Torrents and use file sharing services safely and anonymously without fear of letters from CISPA or your ISP. </span></h4>\n" +
                "<h4><span style=\"color: #999999;\">Unlimited Bandwidth </span></h4>\n" +
                "<h4><span style=\"color: #999999;\">Wether you are an occasional web surfer, or a heavy downloader, you will always receive the best speeds possible with no bandwidth restrictions.</span></h4>\n" +
                "<h4>&nbsp;</h4>\n" +
                "<h2><span style=\"text-decoration: underline;\"><span style=\"color: #999999; text-decoration: underline;\">This application is just for learning purpose as we don't own any VPN server, So it doesn't work.</span></span></h2>\n" +
                " </body>\n" +
                "  </html>";
        WebView Data = (WebView) view.findViewById(R.id.about_app_text);
        Data.loadDataWithBaseURL(null, YourHtmlPage, "text/html", "UTF-8", null);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_about_app, container, false);
        renderWebView();
        return view;
    }

}
