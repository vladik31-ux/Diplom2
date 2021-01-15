package com.example.diplom.Tests.TestsActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diplom.R;
import com.example.diplom.Tests.AssetTests;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ActivityTests3 extends AppCompatActivity { // Кем работать?

    Button firstBtn, secondBtn, thirdBtn;
    ImageView image;
    int f = 0, s = 0, t = 0, counter = 0;
    TextView title, resultTextView;
    int score = 0;
    String result = "", testId = "0";
    JSONArray questions;
    SharedPreferences sp;
    ScrollView scroll;

    int[] answers = new int[30];

    int[] key1 = {0,2,0,0,2,2,0,2,0,2,2,0,2,2,2,2,2,2,2,2,2,0,0,2,2,2,2,0,0,0};
    int[] key3 = {2,0,2,2,0,0,2,0,2,0,0,2,0,0,0,0,0,0,0,0,0,2,2,0,0,0,0,2,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests3);

        firstBtn = findViewById(R.id.firstBtn);
        secondBtn = findViewById(R.id.secondBtn);
        thirdBtn = findViewById(R.id.thirdBtn);
        title = findViewById(R.id.title);
        image = findViewById(R.id.image);
        resultTextView = findViewById(R.id.resultTextView);

        scroll = findViewById(R.id.scroll);

        sp = getSharedPreferences("passList",MODE_PRIVATE);

        try{
            questions = new JSONObject(AssetTests.getStringFromAssetFile(this,"3")).getJSONArray("questions");
            testId =  new JSONObject(AssetTests.getStringFromAssetFile(this,"3")).getString("id");
            fillData();
        }
        catch (Exception e){

            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        firstBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter != 30)
                    answers[counter] = 1;
                fillData();
            }
        });

        secondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter != 30)
                    answers[counter] = 2;
                fillData();
            }
        });

        thirdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter != 30)
                    answers[counter] = 3;
                fillData();
            }
        });
    }

    private void  fillData()
    {
        try {

            title.setText(questions.getJSONObject(counter).getString("title"));
            firstBtn.setText(questions.getJSONObject(counter).getString("key1"));
            secondBtn.setText(questions.getJSONObject(counter).getString("key2"));
            thirdBtn.setText(questions.getJSONObject(counter).getString("key3"));
        }
        catch (Exception e){

            for(int i=0; i < answers.length; i++)
            {
                if(answers[i] == 2) score++;
                if(answers[i] == 1) score += key1[i];
                if(answers[i] == 3) score += key3[i];
            }

            if(score > 48){
                result = "    Вы показали высокий интерес к знаковым системам – это условные знаки, цифры, коды, естественные и искусственные языки. Вы могли бы найти себя в профессиях, связанных с созданием и оформлением документов (на родном или иностранном языке), делопроизводством, анализом текстов и их преобразованием, перекодированием (корректор, секретарь-референт, технический редактор, таможенный декларатор, архивариус, нотариус); числами, количественными соотношениями (экономист, программист, бухгалтер, статистик, демограф, математик), системами условных знаков, схематическими отображениями объектов (чертежник, картограф). Вам интересна кажущаяся многим скучной и монотонной работа с бумагами, цифрами, буквами, документами и т.п. – организация, упорядочивание, анализ, контроль и пр. Вы принимаете решение, тщательно рассмотрев ситуацию и взвесив альтернативы, что делает вас незаменимым в бизнесе, управлении, науках. Однако с вашим самоконтролем, вам не хватает непосредственности (и даже импульсивности), необходимой представителям сферы искусства. Кроме того, могут возникать трудности из-за неумения расслабляться, поэтому вам стоит развивать гибкость в поведении, умение менять свои планы при необходимости, не требовать от себя и окружающих безупречности.";
            }
            else if(score > 38 & score <= 48){
                result = "    Вы показали повышенный интерес к знаковым системам – это условные знаки, цифры, коды, естественные и искусственные языки. Вы могли бы найти себя в профессиях, связанных с созданием и оформлением текстов (на родном или иностранном языке), делопроизводством, анализом текстов и их преобразованием, перекодированием (корректор, секретарь-референт, технический редактор, таможенный декларатор, архивариус, нотариус); числами, количественными соотношениями (экономист, программист, бухгалтер, статистик, демограф, математик), системами условных знаков, схематическими отображениями объектов (чертежник, картограф). Помните, что работа со знаковыми системами требует от человека способности к абстрактному мышлению, длительному и устойчивому сосредоточению внимания, усидчивости. Кроме того, при наличии других, более выраженных интересов, работа со знаковыми системами может быть лишь частью другой, основной профессии (например, активное использование иностранных языков, ведение документации, расчеты – в работе менеджера, юриста, финансиста, журналиста).";
            }
            else if(score > 24 & score <= 38)
            {
                result = "    Вы показали некоторый интерес к знаковым системам. Этот интерес объединяет профессии, связанные с текстами (упорядочение, ведение записей, поиск, анализ и переработка информации, накопление и хранение разного рода сведений) или цифрами, формулами, таблицами, чертежами, схемами (кодирование, схематизация, расчеты). Вы способны аккуратно и точно выполнять работу, при необходимости – дисциплинированы, оперативны. Но при этом сохраняете гибкость и мобильность. Главное – это ваше терпимое отношение к кажущейся многим скучной и монотонной работе с бумагами, цифрами, текстами, документами. Но этот интерес не настолько велик, чтобы однозначно запирать себя в мир знаков. Подумайте, может быть, знаковые системы «суховаты» для вас? При выборе профессии рекомендуем вам ориентироваться на другие, более ярко выраженные у вас интересы.";
            }
            else if(score > 12 & score <= 24)
            {
                result = "    Вам не особо интересно то, что предполагает работу с документами, знаками, цифрами, текстами, бумагами. Скорее всего, вы относитесь к людям более-менее творческим, не любящим работу по алгоритму, монотонную, связанную с «сидением на одном месте», канцелярскую работу, расчеты. Желательно не выбирать должностей, где с Вас будут требовать жесткого соблюдения сроков сдачи работ, где необходимо четкое выполнение инструкций, где предполагается работа с архивами, базами данных, множеством информации в виде схем, чертежей, каталогов. Те сферы, где требуется точность, оперативность, аккуратность, дисциплинированность, ответственность (инженер, юрист, экономист, программист), скорее всего, покажутся вам сухими, скучными и потребуют большого напряжения. Ваша склонность к импровизации, нестандартности, нерегламентированности может быть уместна для представителей творческих профессий, деятелей сферы искусств, а также при работе в условиях неопределенности, частых командировок и т.д. (продюсирование, реклама, дизайн, психология, журналистика и т.д.).";
            }
            else if(score <= 12)
            {
                result = "    Вам совершенно неинтересно все, что предполагает работу с документами, знаками, цифрами, текстами, бумагами. Вы больше цените в жизни сюрпризы и импровизацию. Скорее всего, вы относитесь к людям творческим, ненавидящим работу по алгоритму, монотонную, связанную с «сидением на одном месте». Вам вряд ли подойдут те должности, где с вас будут требовать жесткого соблюдения сроков, где необходимо четкое выполнение инструкций, где предполагается работа с архивами, базами данных. Ваша склонность к импровизации, нестандартности, нерегламентированности может быть уместна для представителей творческих профессий, а также при работе в условиях неопределенности, частых командировок и т.д. (продюсирование, реклама, дизайн, психология, журналистика и т.д.). Однако вы не всегда можете заставить себя делать то, что «надо», вместо того, что «хочется». Это может создать сложности при трудоустройстве, ведь практически любая работа предполагает правила и обязательства.";
            }

            title.setVisibility(View.GONE);
            firstBtn.setVisibility(View.GONE);
            secondBtn.setVisibility(View.GONE);
            thirdBtn.setVisibility(View.GONE);
            image.setVisibility(View.VISIBLE);
            scroll.setVisibility(View.VISIBLE);
            resultTextView.setText(result);
            resultTextView.setVisibility(View.VISIBLE);
            String passList = sp.getString("testsPassed", "");
            if(!passList.isEmpty())
                passList+=" ";
            sp.edit().putString("testsPassed", passList + testId).apply();
        }

        counter++;
    }

}