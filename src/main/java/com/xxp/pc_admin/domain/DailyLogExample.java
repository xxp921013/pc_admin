package com.xxp.pc_admin.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DailyLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DailyLogExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLoginuserIsNull() {
            addCriterion("loginUser is null");
            return (Criteria) this;
        }

        public Criteria andLoginuserIsNotNull() {
            addCriterion("loginUser is not null");
            return (Criteria) this;
        }

        public Criteria andLoginuserEqualTo(Long value) {
            addCriterion("loginUser =", value, "loginuser");
            return (Criteria) this;
        }

        public Criteria andLoginuserNotEqualTo(Long value) {
            addCriterion("loginUser <>", value, "loginuser");
            return (Criteria) this;
        }

        public Criteria andLoginuserGreaterThan(Long value) {
            addCriterion("loginUser >", value, "loginuser");
            return (Criteria) this;
        }

        public Criteria andLoginuserGreaterThanOrEqualTo(Long value) {
            addCriterion("loginUser >=", value, "loginuser");
            return (Criteria) this;
        }

        public Criteria andLoginuserLessThan(Long value) {
            addCriterion("loginUser <", value, "loginuser");
            return (Criteria) this;
        }

        public Criteria andLoginuserLessThanOrEqualTo(Long value) {
            addCriterion("loginUser <=", value, "loginuser");
            return (Criteria) this;
        }

        public Criteria andLoginuserIn(List<Long> values) {
            addCriterion("loginUser in", values, "loginuser");
            return (Criteria) this;
        }

        public Criteria andLoginuserNotIn(List<Long> values) {
            addCriterion("loginUser not in", values, "loginuser");
            return (Criteria) this;
        }

        public Criteria andLoginuserBetween(Long value1, Long value2) {
            addCriterion("loginUser between", value1, value2, "loginuser");
            return (Criteria) this;
        }

        public Criteria andLoginuserNotBetween(Long value1, Long value2) {
            addCriterion("loginUser not between", value1, value2, "loginuser");
            return (Criteria) this;
        }

        public Criteria andRoundIsNull() {
            addCriterion("round is null");
            return (Criteria) this;
        }

        public Criteria andRoundIsNotNull() {
            addCriterion("round is not null");
            return (Criteria) this;
        }

        public Criteria andRoundEqualTo(Long value) {
            addCriterion("round =", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundNotEqualTo(Long value) {
            addCriterion("round <>", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundGreaterThan(Long value) {
            addCriterion("round >", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundGreaterThanOrEqualTo(Long value) {
            addCriterion("round >=", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundLessThan(Long value) {
            addCriterion("round <", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundLessThanOrEqualTo(Long value) {
            addCriterion("round <=", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundIn(List<Long> values) {
            addCriterion("round in", values, "round");
            return (Criteria) this;
        }

        public Criteria andRoundNotIn(List<Long> values) {
            addCriterion("round not in", values, "round");
            return (Criteria) this;
        }

        public Criteria andRoundBetween(Long value1, Long value2) {
            addCriterion("round between", value1, value2, "round");
            return (Criteria) this;
        }

        public Criteria andRoundNotBetween(Long value1, Long value2) {
            addCriterion("round not between", value1, value2, "round");
            return (Criteria) this;
        }

        public Criteria andArticleIsNull() {
            addCriterion("article is null");
            return (Criteria) this;
        }

        public Criteria andArticleIsNotNull() {
            addCriterion("article is not null");
            return (Criteria) this;
        }

        public Criteria andArticleEqualTo(Long value) {
            addCriterion("article =", value, "article");
            return (Criteria) this;
        }

        public Criteria andArticleNotEqualTo(Long value) {
            addCriterion("article <>", value, "article");
            return (Criteria) this;
        }

        public Criteria andArticleGreaterThan(Long value) {
            addCriterion("article >", value, "article");
            return (Criteria) this;
        }

        public Criteria andArticleGreaterThanOrEqualTo(Long value) {
            addCriterion("article >=", value, "article");
            return (Criteria) this;
        }

        public Criteria andArticleLessThan(Long value) {
            addCriterion("article <", value, "article");
            return (Criteria) this;
        }

        public Criteria andArticleLessThanOrEqualTo(Long value) {
            addCriterion("article <=", value, "article");
            return (Criteria) this;
        }

        public Criteria andArticleIn(List<Long> values) {
            addCriterion("article in", values, "article");
            return (Criteria) this;
        }

        public Criteria andArticleNotIn(List<Long> values) {
            addCriterion("article not in", values, "article");
            return (Criteria) this;
        }

        public Criteria andArticleBetween(Long value1, Long value2) {
            addCriterion("article between", value1, value2, "article");
            return (Criteria) this;
        }

        public Criteria andArticleNotBetween(Long value1, Long value2) {
            addCriterion("article not between", value1, value2, "article");
            return (Criteria) this;
        }

        public Criteria andNewuserIsNull() {
            addCriterion("newUser is null");
            return (Criteria) this;
        }

        public Criteria andNewuserIsNotNull() {
            addCriterion("newUser is not null");
            return (Criteria) this;
        }

        public Criteria andNewuserEqualTo(Long value) {
            addCriterion("newUser =", value, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserNotEqualTo(Long value) {
            addCriterion("newUser <>", value, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserGreaterThan(Long value) {
            addCriterion("newUser >", value, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserGreaterThanOrEqualTo(Long value) {
            addCriterion("newUser >=", value, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserLessThan(Long value) {
            addCriterion("newUser <", value, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserLessThanOrEqualTo(Long value) {
            addCriterion("newUser <=", value, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserIn(List<Long> values) {
            addCriterion("newUser in", values, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserNotIn(List<Long> values) {
            addCriterion("newUser not in", values, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserBetween(Long value1, Long value2) {
            addCriterion("newUser between", value1, value2, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserNotBetween(Long value1, Long value2) {
            addCriterion("newUser not between", value1, value2, "newuser");
            return (Criteria) this;
        }

        public Criteria andArticleReadIsNull() {
            addCriterion("article_read is null");
            return (Criteria) this;
        }

        public Criteria andArticleReadIsNotNull() {
            addCriterion("article_read is not null");
            return (Criteria) this;
        }

        public Criteria andArticleReadEqualTo(Long value) {
            addCriterion("article_read =", value, "articleRead");
            return (Criteria) this;
        }

        public Criteria andArticleReadNotEqualTo(Long value) {
            addCriterion("article_read <>", value, "articleRead");
            return (Criteria) this;
        }

        public Criteria andArticleReadGreaterThan(Long value) {
            addCriterion("article_read >", value, "articleRead");
            return (Criteria) this;
        }

        public Criteria andArticleReadGreaterThanOrEqualTo(Long value) {
            addCriterion("article_read >=", value, "articleRead");
            return (Criteria) this;
        }

        public Criteria andArticleReadLessThan(Long value) {
            addCriterion("article_read <", value, "articleRead");
            return (Criteria) this;
        }

        public Criteria andArticleReadLessThanOrEqualTo(Long value) {
            addCriterion("article_read <=", value, "articleRead");
            return (Criteria) this;
        }

        public Criteria andArticleReadIn(List<Long> values) {
            addCriterion("article_read in", values, "articleRead");
            return (Criteria) this;
        }

        public Criteria andArticleReadNotIn(List<Long> values) {
            addCriterion("article_read not in", values, "articleRead");
            return (Criteria) this;
        }

        public Criteria andArticleReadBetween(Long value1, Long value2) {
            addCriterion("article_read between", value1, value2, "articleRead");
            return (Criteria) this;
        }

        public Criteria andArticleReadNotBetween(Long value1, Long value2) {
            addCriterion("article_read not between", value1, value2, "articleRead");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("`date` is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("`date` is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterion("`date` =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterion("`date` <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterion("`date` >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterion("`date` >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterion("`date` <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterion("`date` <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterion("`date` in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterion("`date` not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterion("`date` between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterion("`date` not between", value1, value2, "date");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}