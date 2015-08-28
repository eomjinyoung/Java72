-- 주문정보
DROP TABLE IF EXISTS ORDR RESTRICT;

-- 제품사진
DROP TABLE IF EXISTS PROD_IMG RESTRICT;

-- 제품
DROP TABLE IF EXISTS PROD RESTRICT;

-- 제조사
DROP TABLE IF EXISTS MAKR RESTRICT;

-- 회원
DROP TABLE IF EXISTS MEMB RESTRICT;

-- 주소
DROP TABLE IF EXISTS ADDR RESTRICT;

-- 상품평
DROP TABLE IF EXISTS REVW RESTRICT;

-- 회원사진
DROP TABLE IF EXISTS MEMB_IMG RESTRICT;

-- 주문정보
CREATE TABLE ORDR (
  ONO        INTEGER     NOT NULL COMMENT '주문번호', -- 주문번호
  PNO        INTEGER     NOT NULL COMMENT '제품번호', -- 제품번호
  MNO        INTEGER     NOT NULL COMMENT '회원번호', -- 회원번호
  QTY        INTEGER     NOT NULL COMMENT '주문수량', -- 주문수량
  CR_DT      DATETIME    NOT NULL COMMENT '주문일', -- 주문일
  PAY_MT     VARCHAR(10) NOT NULL COMMENT '결제방법', -- 결제방법
  PAY_YN     CHAR(1)     NOT NULL COMMENT '결제여부', -- 결제여부
  PAY_ACC_NO INTEGER     NULL     COMMENT '결제승인번호' -- 결제승인번호
)
COMMENT '주문정보';

-- 주문정보
ALTER TABLE ORDR
  ADD CONSTRAINT PK_ORDR -- 주문정보 기본키
    PRIMARY KEY (
      ONO -- 주문번호
    );

-- 주문정보 유니크 인덱스
CREATE UNIQUE INDEX UIX_ORDR
  ON ORDR ( -- 주문정보
    PAY_ACC_NO ASC -- 결제승인번호
  );

ALTER TABLE ORDR
  MODIFY COLUMN ONO INTEGER NOT NULL AUTO_INCREMENT COMMENT '주문번호';

-- 제품사진
CREATE TABLE PROD_IMG (
  PPNO     INTEGER      NOT NULL COMMENT '제품사진번호', -- 제품사진번호
  FILEPATH VARCHAR(255) NOT NULL COMMENT '사진경로', -- 사진경로
  PNO      INTEGER      NOT NULL COMMENT '제품번호' -- 제품번호
)
COMMENT '제품사진';

-- 제품사진
ALTER TABLE PROD_IMG
  ADD CONSTRAINT PK_PROD_IMG -- 제품사진 기본키
    PRIMARY KEY (
      PPNO -- 제품사진번호
    );

ALTER TABLE PROD_IMG
  MODIFY COLUMN PPNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '제품사진번호';

-- 제품
CREATE TABLE PROD (
  PNO   INTEGER      NOT NULL COMMENT '제품번호', -- 제품번호
  TITLE VARCHAR(255) NOT NULL COMMENT '제품명', -- 제품명
  DSCR  MEDIUMTEXT   NOT NULL COMMENT '설명', -- 설명
  QTY   INTEGER      NOT NULL COMMENT '수량', -- 수량
  MKNO  INTEGER      NOT NULL COMMENT '제조사번호' -- 제조사번호
)
COMMENT '제품';

-- 제품
ALTER TABLE PROD
  ADD CONSTRAINT PK_PROD -- 제품 기본키
    PRIMARY KEY (
      PNO -- 제품번호
    );

-- 제품 인덱스
CREATE INDEX IX_PROD
  ON PROD( -- 제품
    TITLE ASC -- 제품명
  );

ALTER TABLE PROD
  MODIFY COLUMN PNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '제품번호';

-- 제조사
CREATE TABLE MAKR (
  MKNO   INTEGER      NOT NULL COMMENT '제조사번호', -- 제조사번호
  MKNAME VARCHAR(100) NOT NULL COMMENT '제좋사명', -- 제좋사명
  WWW    VARCHAR(255) NOT NULL COMMENT '홈페이지', -- 홈페이지
  TEL    VARCHAR(20)  NOT NULL COMMENT '전화', -- 전화
  FAX    VARCHAR(20)  NULL     COMMENT '팩스', -- 팩스
  MKCODE VARCHAR(20)  NOT NULL COMMENT '사업자번호' -- 사업자번호
)
COMMENT '제조사';

-- 제조사
ALTER TABLE MAKR
  ADD CONSTRAINT PK_MAKR -- 제조사 기본키
    PRIMARY KEY (
      MKNO -- 제조사번호
    );

-- 제조사 유니크 인덱스
CREATE UNIQUE INDEX UIX_MAKR
  ON MAKR ( -- 제조사
    MKCODE ASC -- 사업자번호
  );

ALTER TABLE MAKR
  MODIFY COLUMN MKNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '제조사번호';

-- 회원
CREATE TABLE MEMB (
  MNO      INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
  MNAME    VARCHAR(100) NOT NULL COMMENT '이름', -- 이름
  TEL      VARCHAR(20)  NULL     COMMENT '전화', -- 전화
  EMAIL    VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
  ANO      INTEGER      NULL     COMMENT '주소번호', -- 주소번호
  DET_ADDR VARCHAR(255) NULL     COMMENT '상세주소' -- 상세주소
)
COMMENT '회원';

-- 회원
ALTER TABLE MEMB
  ADD CONSTRAINT PK_MEMB -- 회원 기본키
    PRIMARY KEY (
      MNO -- 회원번호
    );

-- 회원 유니크 인덱스
CREATE UNIQUE INDEX UIX_MEMB
  ON MEMB ( -- 회원
    EMAIL ASC -- 이메일
  );

-- 회원 인덱스
CREATE INDEX IX_MEMB
  ON MEMB( -- 회원
    MNAME ASC -- 이름
  );

ALTER TABLE MEMB
  MODIFY COLUMN MNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원번호';

-- 주소
CREATE TABLE ADDR (
  ANO      INTEGER      NOT NULL COMMENT '주소번호', -- 주소번호
  POSTNO   VARCHAR(10)  NOT NULL COMMENT '우편번호', -- 우편번호
  BAS_ADDR VARCHAR(255) NOT NULL COMMENT '기본주소' -- 기본주소
)
COMMENT '주소';

-- 주소
ALTER TABLE ADDR
  ADD CONSTRAINT PK_ADDR -- 주소 기본키
    PRIMARY KEY (
      ANO -- 주소번호
    );

-- 주소 인덱스
CREATE INDEX IX_ADDR
  ON ADDR( -- 주소
    BAS_ADDR ASC -- 기본주소
  );

ALTER TABLE ADDR
  MODIFY COLUMN ANO INTEGER NOT NULL AUTO_INCREMENT COMMENT '주소번호';

-- 상품평
CREATE TABLE REVW (
  MNO     INTEGER    NOT NULL COMMENT '회원번호', -- 회원번호
  PNO     INTEGER    NOT NULL COMMENT '제품번호', -- 제품번호
  CONTENT MEDIUMTEXT NOT NULL COMMENT '내용', -- 내용
  CR_DT   DATETIME   NOT NULL COMMENT '일시' -- 일시
)
COMMENT '상품평';

-- 상품평
ALTER TABLE REVW
  ADD CONSTRAINT PK_REVW -- 상품평 기본키
    PRIMARY KEY (
      MNO, -- 회원번호
      PNO  -- 제품번호
    );

-- 회원사진
CREATE TABLE MEMB_IMG (
  MNO      INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
  FILEPATH VARCHAR(255) NULL     COMMENT '사진경로' -- 사진경로
)
COMMENT '회원사진';

-- 회원사진
ALTER TABLE MEMB_IMG
  ADD CONSTRAINT PK_MEMB_IMG -- 회원사진 기본키
    PRIMARY KEY (
      MNO -- 회원번호
    );

-- 주문정보
ALTER TABLE ORDR
  ADD CONSTRAINT FK_PROD_TO_ORDR -- 제품 -> 주문정보
    FOREIGN KEY (
      PNO -- 제품번호
    )
    REFERENCES PROD ( -- 제품
      PNO -- 제품번호
    );

-- 주문정보
ALTER TABLE ORDR
  ADD CONSTRAINT FK_MEMB_TO_ORDR -- 회원 -> 주문정보
    FOREIGN KEY (
      MNO -- 회원번호
    )
    REFERENCES MEMB ( -- 회원
      MNO -- 회원번호
    );

-- 제품사진
ALTER TABLE PROD_IMG
  ADD CONSTRAINT FK_PROD_TO_PROD_IMG -- 제품 -> 제품사진
    FOREIGN KEY (
      PNO -- 제품번호
    )
    REFERENCES PROD ( -- 제품
      PNO -- 제품번호
    );

-- 제품
ALTER TABLE PROD
  ADD CONSTRAINT FK_MAKR_TO_PROD -- 제조사 -> 제품
    FOREIGN KEY (
      MKNO -- 제조사번호
    )
    REFERENCES MAKR ( -- 제조사
      MKNO -- 제조사번호
    );

-- 회원
ALTER TABLE MEMB
  ADD CONSTRAINT FK_ADDR_TO_MEMB -- 주소 -> 회원
    FOREIGN KEY (
      ANO -- 주소번호
    )
    REFERENCES ADDR ( -- 주소
      ANO -- 주소번호
    );

-- 상품평
ALTER TABLE REVW
  ADD CONSTRAINT FK_MEMB_TO_REVW -- 회원 -> 상품평
    FOREIGN KEY (
      MNO -- 회원번호
    )
    REFERENCES MEMB ( -- 회원
      MNO -- 회원번호
    );

-- 상품평
ALTER TABLE REVW
  ADD CONSTRAINT FK_PROD_TO_REVW -- 제품 -> 상품평
    FOREIGN KEY (
      PNO -- 제품번호
    )
    REFERENCES PROD ( -- 제품
      PNO -- 제품번호
    );

-- 회원사진
ALTER TABLE MEMB_IMG
  ADD CONSTRAINT FK_MEMB_TO_MEMB_IMG -- 회원 -> 회원사진
    FOREIGN KEY (
      MNO -- 회원번호
    )
    REFERENCES MEMB ( -- 회원
      MNO -- 회원번호
    );