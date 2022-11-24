package com.example.motivation.data

import com.example.motivation.infra.MotivationConstants
import kotlin.random.Random

data class Phrase(val descriptor: String, val categoryId: Int) {

}


class Mock {

    private val all = MotivationConstants.FILTER.ALL
    private val happy = MotivationConstants.FILTER.HAPPY
    private val sunny = MotivationConstants.FILTER.SUNNY


   private val mListPhrase = listOf<Phrase>(
        Phrase("Não importa o que você faça, faça tudo com a intenção de CUMER ALGUEM.", happy),
        Phrase("Você é um bosta!", happy),
        Phrase("Carlos Pescotapa!", happy),
        Phrase("EU SOU SEU PAI! EU SOU JESUS!", happy),
        Phrase("CALADO!.", happy),
        Phrase("Eu tenho um show de mágica pra você. Eu trabalho em 2 empregos, 7 dias por semana e todo dia meu dinheiro some.", sunny),
        Phrase("Palmeiras não tem mundial pega no meu bilau", happy),
        Phrase("Essa gente inventa cada coisa.", sunny),
        Phrase("Você disse PIPOCA?.", sunny),
        Phrase("Você que lute pra entender esse codigo.", sunny),
        Phrase("'Não é errado se te faz feliz' ass.: CAPETA.", sunny),
        Phrase("Trágico…TRÁGICO.", sunny),
        Phrase("Eu vou pegar o xarope!", sunny),


        )

        fun getPhrase(value: Int): String {
            val filtered = mListPhrase.filter {it.categoryId == value || value  == all }
            return  filtered[Random.nextInt(filtered.size)].descriptor
        }

}
