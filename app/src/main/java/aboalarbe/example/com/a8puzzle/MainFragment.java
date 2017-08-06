package aboalarbe.example.com.a8puzzle;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mohamed_aboalarbe on 8/1/2016.
 */

public class MainFragment extends Fragment {
    private Button[] buttons;
    @BindView(R.id.play)
    Button play;
    @BindView(R.id.reset)
    Button reset;
    @BindView(R.id.moves)
    TextView moves;
    @BindView(R.id.timer)
    Chronometer timer;
    private int counter = 0;
    private static final String[] arr = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", ""};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, rootView);

        buttons = new Button[9];
        buttons[0] = (Button) rootView.findViewById(R.id.one);
        buttons[1] = (Button) rootView.findViewById(R.id.two);
        buttons[2] = (Button) rootView.findViewById(R.id.three);
        buttons[3] = (Button) rootView.findViewById(R.id.four);
        buttons[4] = (Button) rootView.findViewById(R.id.five);
        buttons[5] = (Button) rootView.findViewById(R.id.six);
        buttons[6] = (Button) rootView.findViewById(R.id.seven);
        buttons[7] = (Button) rootView.findViewById(R.id.eight);
        buttons[8] = (Button) rootView.findViewById(R.id.space);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restGame();
            }
        });

        gameRules();

        return rootView;
    }

    private void playGame() {
        Collections.shuffle(Arrays.asList(arr));
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(true);
            buttons[i].setText(arr[i]);
        }
        play.setEnabled(false);
        timer.setBase(SystemClock.elapsedRealtime());
        timer.start();
    }

    private void restGame() {
        String[] static_arr = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", ""};
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
            buttons[i].setText(static_arr[i]);
        }
        play.setEnabled(true);
        timer.stop();
        timer.setBase(SystemClock.elapsedRealtime());
        timer.setText("00");
        counter = 0;
        moves.setText("00");
    }

    private void gameRules() {
        buttons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttons[1].getText().toString().equals("")) {
                    swap(0, 1);
                    counter++;
                    moves.setText(counter + "");
                    ifWin();
                } else if (buttons[3].getText().toString().equals("")) {
                    swap(0, 3);
                    counter++;
                    moves.setText(counter + "");
                    ifWin();
                }
            }
        });
        buttons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttons[2].getText().toString().equals("")) {
                    swap(2, 1);
                    counter++;
                    moves.setText(counter + "");
                    ifWin();
                } else if (buttons[0].getText().toString().equals("")) {
                    swap(0, 1);
                    counter++;
                    moves.setText(counter + "");
                    ifWin();
                } else if (buttons[4].getText().toString().equals("")) {
                    swap(1, 4);
                    counter++;
                    moves.setText(counter + "");
                    ifWin();
                }
            }
        });
        buttons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttons[1].getText().toString().equals("")) {
                    swap(2, 1);
                    counter++;
                    moves.setText(counter + "");
                    ifWin();
                } else if (buttons[5].getText().toString().equals("")) {
                    swap(2, 5);
                    counter++;
                    moves.setText(counter + "");
                    ifWin();
                }
            }
        });
        buttons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttons[0].getText().toString().equals("")) {
                    swap(0, 3);
                    counter++;
                    moves.setText(counter + "");
                    ifWin();
                } else if (buttons[4].getText().toString().equals("")) {
                    swap(3, 4);
                    counter++;
                    moves.setText(counter + "");
                    ifWin();
                } else if (buttons[6].getText().toString().equals("")) {
                    swap(3, 6);
                    counter++;
                    moves.setText(counter + "");
                    ifWin();
                }
            }
        });
        buttons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttons[1].getText().toString().equals("")) {
                    swap(1, 4);
                    counter++;
                    moves.setText(counter + "");
                    ifWin();
                } else if (buttons[3].getText().toString().equals("")) {
                    swap(3, 4);
                    counter++;
                    moves.setText(counter + "");
                    ifWin();
                } else if (buttons[5].getText().toString().equals("")) {
                    swap(4, 5);
                    counter++;
                    moves.setText(counter + "");
                    ifWin();
                } else if (buttons[7].getText().toString().equals("")) {
                    swap(4, 7);
                    counter++;
                    moves.setText(counter + "");
                    ifWin();
                }
            }
        });
        buttons[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttons[2].getText().toString().equals("")) {
                    swap(2, 5);
                    counter++;
                    moves.setText(counter + "");
                    ifWin();
                } else if (buttons[4].getText().toString().equals("")) {
                    swap(4, 5);
                    counter++;
                    moves.setText(counter + "");
                    ifWin();
                } else if (buttons[8].getText().toString().equals("")) {
                    swap(5, 8);
                    counter++;
                    moves.setText(counter + "");
                    ifWin();
                }
            }
        });
        buttons[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttons[3].getText().toString().equals("")) {
                    swap(3, 6);
                    counter++;
                    moves.setText(counter + "");
                    ifWin();
                } else if (buttons[7].getText().toString().equals("")) {
                    swap(6, 7);
                    counter++;
                    moves.setText(counter + "");
                    ifWin();
                }
            }
        });
        buttons[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttons[4].getText().toString().equals("")) {
                    swap(4, 7);
                    counter++;
                    moves.setText(counter + "");
                    ifWin();
                } else if (buttons[6].getText().toString().equals("")) {
                    swap(6, 7);
                    counter++;
                    moves.setText(counter + "");
                    ifWin();
                } else if (buttons[8].getText().toString().equals("")) {
                    swap(7, 8);
                    counter++;
                    moves.setText(counter + "");
                    ifWin();
                }
            }
        });
        buttons[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttons[5].getText().toString().equals("")) {
                    swap(5, 8);
                    counter++;
                    moves.setText(counter + "");
                    ifWin();
                } else if (buttons[7].getText().toString().equals("")) {
                    swap(7, 8);
                    counter++;
                    moves.setText(counter + "");
                    ifWin();
                }
            }
        });
    }

    private void ifWin() {
        if (buttons[0].getText().toString().equals("1") && buttons[1].getText().toString().equals("2")
                && buttons[2].getText().toString().equals("3") && buttons[3].getText().toString().equals("4")
                && buttons[4].getText().toString().equals("5") && buttons[5].getText().toString().equals("6")
                && buttons[6].getText().toString().equals("7") && buttons[7].getText().toString().equals("8")
                && buttons[8].getText().toString().equals("")) {
            Toast.makeText(getActivity(), getActivity().getString(R.string.win),
                    Toast.LENGTH_LONG).show();
        }
    }

    private void swap(int x, int y) {
        String one = buttons[x].getText().toString();
        String two = buttons[y].getText().toString();
        buttons[y].setText(one);
        buttons[x].setText(two);
    }
}