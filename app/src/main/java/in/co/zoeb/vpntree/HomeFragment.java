package in.co.zoeb.vpntree;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.VpnService;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    MyVpnService vpnService;
    boolean isBound = false;

    private View view;
    private ImageView connect, connected, error;

    public HomeFragment() {
        // Required empty public constructor
    }

    private void configureSettings() {

        connect = (ImageView) view.findViewById(R.id.connect_view);
        connected = (ImageView) view.findViewById(R.id.connected_view);
        error = (ImageView) view.findViewById(R.id.errorconnect_view);

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = VpnService.prepare(getActivity().getApplicationContext());
                if (intent != null) {
                    startActivityForResult(intent, 0);
                    connect.setVisibility(View.INVISIBLE);
                    connected.setVisibility(View.VISIBLE);
                    error.setVisibility(View.INVISIBLE);
                } else {
                    connect.setVisibility(View.INVISIBLE);
                    connected.setVisibility(View.VISIBLE);
                    error.setVisibility(View.INVISIBLE);
                    onActivityResult(0, RESULT_OK, null);
                }

            }
        });

        connected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vpnService.stopVpn();
                connect.setVisibility(View.VISIBLE);
                connected.setVisibility(View.INVISIBLE);
                error.setVisibility(View.INVISIBLE);
            }
        });

        error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connect.setVisibility(View.VISIBLE);
                connected.setVisibility(View.INVISIBLE);
                error.setVisibility(View.INVISIBLE);
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        configureSettings();
        return view;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Intent intent = new Intent(getActivity(), MyVpnService.class);
            getActivity().bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
            getActivity().startService(intent);
        } else {
            Toast.makeText(getActivity(), "A VPN is already connected", Toast.LENGTH_LONG).show();
        }
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // get a ref to the binder class and call the bind method
            MyVpnService.MyLocalBinder binder = (MyVpnService.MyLocalBinder) service;
            vpnService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };

    @Override
    public void onDestroy() {
        try {
            vpnService.stopVpn();
        } catch (NullPointerException ignored) {}
        super.onDestroy();
    }
}
