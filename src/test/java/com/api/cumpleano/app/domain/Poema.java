package com.api.cumpleano.app.domain;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.cumpleano.app.poem.domain.Poem;
import com.api.cumpleano.app.poem.domain.Poet;

@SpringBootTest
public class Poema {

	String mustBeANotnull = "Must be a not null";

	@Test
	public void poemTest() {

		Poem poem = new Poem();

		poem.setTitle("The Echo Of The Royal Porch");
		poem.setUrl("https://www.poemist.com/james-wilson-claudero/the-echo-of-the-royal-porch");
		poem.setContent(
				"Ye Sons of Mars, with black cockade, \\nWho wear the gun and murd'ring blade, \\nAgainst your foes in battle hot, \\nAnd die, or conquer on the spot; \\nTo devastation ye are bred, \\nBy blood ye swear, and blood's your trade. \\nNo--- (Echo then reply'd aloud,) \\nThey do not always deal in blood; \\nNor yet in breaking human bones; \\nFor Quixotte-like they knock down stones. \\nRegardless they the mattock ply, \\nTo root our Scots antiquity. \\nMy aged arch for cent'ries ten \\nHath spared been by Scottish men. \\nAs Judah's porches, sacred mine, \\nWhere Kings did rule by right divine. \\nYour antient Kings did enter here, \\nTho' strangers now for many a year; \\nAnd many barons in my sight, \\nWere honour'd with the title, Knight, \\nWhose race now tamely sees my fall, \\nRelentless at my mournful call. \\nWhen Red-coats struck, I loud did shriek, \\nAnd to Auld Reikie thus did speak: \\nWhat is my crime? Oh! what my blot? \\nAuld Reikie cry'd, Thou'rt an oldScot. \\nWhat then? my Echo loud did cry, \\nMust Scots antiquity now die? \\nYes, cry'd Auld Reikie, die you must, \\nFor ----- at you has a disgust. \\nMy cross likewise, of old renown, \\nWill next to you be tumbled down; \\nAnd by degrees each antient place \\nWill perish by this modern race. \\nMy Echo then did loud rebound, \\nWith cries which shook the neighb'ring ground; \\nAnd, all amaz'd, the soldier bands \\nSuspended stood with trembling hands; \\nWhile these sad accents I let fly, \\nWhich sharply pierc'd the azure sky: \\nAdieu, Edina, now adieu, \\nFair Scotia's glory's gone. \\nThis said, she bow'd her antient head, \\nAnd gave the final groan. \\nEdina echo'd then aloud, \\nAnd bid her long farewel; \\nThe Calton-hill and Arthur's seat \\nDid ring her parting knell.");
		Poet poet = new Poet();
		poet.setName("James Wilson Claudero");
		poet.setUrl("https://www.poemist.com/james-wilson-claudero");
		poem.setPoet(poet);

		poem.getTitle();
		poem.getContent();
		poem.getUrl();
		poem.getPoet().getName();
		poem.getPoet().getUrl();

		assertNotNull(mustBeANotnull, poem);

	}
}
