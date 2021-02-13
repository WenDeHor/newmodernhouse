package com.example.newmodernhouse.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "technical_task")
public class TechnicalTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_task")
    private Long idTask;
    String nameTask;
    boolean architecture; //Архітектурні рішення - плани, розрізи фасади. Ескізні наміри забудови
    boolean landscaping; //Благоустрій, озелення, генеральний план
    boolean constructive; //Конструктивні рішення. Розрахунок конструкцій, елементів, вузлів
    boolean specification; // Складання специфікацій на будівельні матеріали, витрат, технології постачання та облаштування
    boolean engineering; //Інженерні куомунікації. Вода, електрика, тепловітеплові мережі, вентиляція
    boolean engineering_energy; //Альтернативна енергетика. Сонячна, повітряна, теплова
    String house_name; //Назва будинку
    String phone;
    @Size(min = 0, max = 2000)
    String text;
    Integer price;
}


