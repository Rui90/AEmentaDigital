package com.example.rui.aementadigital;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by guilh_000 on 07/11/2014.
 */
public class AskPassword extends Fragment {

    private static final int PASSWORD = 6004;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.askpassword, container, false);

        final Button button1 = (Button) view.findViewById(R.id.button1);
        final Button button2 = (Button) view.findViewById(R.id.button2);
        final Button button3 = (Button) view.findViewById(R.id.button3);
        final Button button4 = (Button) view.findViewById(R.id.button4);
        final Button button5 = (Button) view.findViewById(R.id.button5);
        final Button button6 = (Button) view.findViewById(R.id.button6);
        final Button button7 = (Button) view.findViewById(R.id.button7);
        final Button button8 = (Button) view.findViewById(R.id.button8);
        final Button button9 = (Button) view.findViewById(R.id.button9);
        final Button button10 = (Button) view.findViewById(R.id.button10);
        final Button buttonDelete = (Button) view.findViewById(R.id.deletetext);
        final TextView password = (TextView) view.findViewById(R.id.password);
        final TextView passwordCount = (TextView) view.findViewById(R.id.viewPassword);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String textToSet = password.getText().toString() + button1.getText().toString();
                password.setText(textToSet);
                passwordCount.setText(passwordCount.getText().toString() + "*");
                if (password.getText().toString().length() == 4) {
                    if (Integer.parseInt(password.getText().toString()) == PASSWORD) {

                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "Password errada, por favor insira novamente!",
                                Toast.LENGTH_LONG).show();
                        password.setText(null);
                        passwordCount.setText(null);
                    }
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String textToSet = password.getText().toString() + button2.getText().toString();
                password.setText(textToSet);
                passwordCount.setText(passwordCount.getText().toString() + "*");
                if (password.getText().toString().length() == 4) {
                    if (Integer.parseInt(password.getText().toString()) == PASSWORD) {

                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "Password errada, por favor insira novamente!",
                                Toast.LENGTH_LONG).show();
                        password.setText(null);
                        passwordCount.setText(null);
                    }
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String textToSet = password.getText().toString() + button3.getText().toString();
                password.setText(textToSet);
                passwordCount.setText(passwordCount.getText().toString() + "*");
                if (password.getText().toString().length() == 4) {
                    if (Integer.parseInt(password.getText().toString()) == PASSWORD) {

                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "Password errada, por favor insira novamente!",
                                Toast.LENGTH_LONG).show();
                        password.setText(null);
                        passwordCount.setText(null);
                    }
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String textToSet = password.getText().toString() + button4.getText().toString();
                password.setText(textToSet);
                passwordCount.setText(passwordCount.getText().toString() + "*");
                if (password.getText().toString().length() == 4) {
                    if (Integer.parseInt(password.getText().toString()) == PASSWORD) {

                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "Password errada, por favor insira novamente!",
                                Toast.LENGTH_LONG).show();
                        password.setText(null);
                        passwordCount.setText(null);
                    }
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String textToSet = password.getText().toString() + button5.getText().toString();
                password.setText(textToSet);
                passwordCount.setText(passwordCount.getText().toString() + "*");
                if (password.getText().toString().length() == 4) {
                    if (Integer.parseInt(password.getText().toString()) == PASSWORD) {

                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "Password errada, por favor insira novamente!",
                                Toast.LENGTH_LONG).show();
                        password.setText(null);
                        passwordCount.setText(null);
                    }
                }
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String textToSet = password.getText().toString() + button6.getText().toString();
                password.setText(textToSet);
                passwordCount.setText(passwordCount.getText().toString() + "*");
                if (password.getText().toString().length() == 4) {
                    if (Integer.parseInt(password.getText().toString()) == PASSWORD) {

                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "Password errada, por favor insira novamente!",
                                Toast.LENGTH_LONG).show();
                        password.setText(null);
                        passwordCount.setText(null);
                    }
                }
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String textToSet = password.getText().toString() + button7.getText().toString();
                password.setText(textToSet);
                passwordCount.setText(passwordCount.getText().toString() + "*");
                if (password.getText().toString().length() == 4) {
                    if (Integer.parseInt(password.getText().toString()) == PASSWORD) {

                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "Password errada, por favor insira novamente!",
                                Toast.LENGTH_LONG).show();
                        password.setText(null);
                        passwordCount.setText(null);
                    }
                }
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String textToSet = password.getText().toString() + button8.getText().toString();
                password.setText(textToSet);
                passwordCount.setText(passwordCount.getText().toString() + "*");
                if (password.getText().toString().length() == 4) {
                    if (Integer.parseInt(password.getText().toString()) == PASSWORD) {

                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "Password errada, por favor insira novamente!",
                                Toast.LENGTH_LONG).show();
                        password.setText(null);
                        passwordCount.setText(null);
                    }
                }
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String textToSet = password.getText().toString() + button9.getText().toString();
                password.setText(textToSet);
                passwordCount.setText(passwordCount.getText().toString() + "*");
                if (password.getText().toString().length() == 4) {
                    if (Integer.parseInt(password.getText().toString()) == PASSWORD) {

                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "Password errada, por favor insira novamente!",
                                Toast.LENGTH_LONG).show();
                        password.setText(null);
                        passwordCount.setText(null);
                    }
                }
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String textToSet = password.getText().toString() + button10.getText().toString();
                password.setText(textToSet);
                passwordCount.setText(passwordCount.getText().toString() + "*");
                if (password.getText().toString().length() == 4) {
                    if (Integer.parseInt(password.getText().toString()) == PASSWORD) {

                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "Password errada, por favor insira novamente!",
                                Toast.LENGTH_LONG).show();
                        password.setText(null);
                        passwordCount.setText(null);
                    }
                }
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int length = password.getText().toString().length();
                if (length == 1) {
                    password.setText(null);
                    passwordCount.setText(null);
                } else if (length == 2) {
                    char c = password.getText().toString().charAt(0);
                    password.setText("" + c);
                    passwordCount.setText("*");
                } else if (length == 3) {
                    char c1 = password.getText().toString().charAt(0);
                    char c2 = password.getText().toString().charAt(1);
                    password.setText("" + c1 + c2);
                    passwordCount.setText("**");
                }
            }
        });
        return view;
    }
}
