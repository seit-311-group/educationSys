package cn.sysu.educationSys.pojo;

import java.util.ArrayList;
import java.util.List;

public class questionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public questionExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andPointidIsNull() {
            addCriterion("pointID is null");
            return (Criteria) this;
        }

        public Criteria andPointidIsNotNull() {
            addCriterion("pointID is not null");
            return (Criteria) this;
        }

        public Criteria andPointidEqualTo(String value) {
            addCriterion("pointID =", value, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidNotEqualTo(String value) {
            addCriterion("pointID <>", value, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidGreaterThan(String value) {
            addCriterion("pointID >", value, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidGreaterThanOrEqualTo(String value) {
            addCriterion("pointID >=", value, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidLessThan(String value) {
            addCriterion("pointID <", value, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidLessThanOrEqualTo(String value) {
            addCriterion("pointID <=", value, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidLike(String value) {
            addCriterion("pointID like", value, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidNotLike(String value) {
            addCriterion("pointID not like", value, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidIn(List<String> values) {
            addCriterion("pointID in", values, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidNotIn(List<String> values) {
            addCriterion("pointID not in", values, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidBetween(String value1, String value2) {
            addCriterion("pointID between", value1, value2, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidNotBetween(String value1, String value2) {
            addCriterion("pointID not between", value1, value2, "pointid");
            return (Criteria) this;
        }

        public Criteria andSubquesidIsNull() {
            addCriterion("subquesID is null");
            return (Criteria) this;
        }

        public Criteria andSubquesidIsNotNull() {
            addCriterion("subquesID is not null");
            return (Criteria) this;
        }

        public Criteria andSubquesidEqualTo(String value) {
            addCriterion("subquesID =", value, "subquesid");
            return (Criteria) this;
        }

        public Criteria andSubquesidNotEqualTo(String value) {
            addCriterion("subquesID <>", value, "subquesid");
            return (Criteria) this;
        }

        public Criteria andSubquesidGreaterThan(String value) {
            addCriterion("subquesID >", value, "subquesid");
            return (Criteria) this;
        }

        public Criteria andSubquesidGreaterThanOrEqualTo(String value) {
            addCriterion("subquesID >=", value, "subquesid");
            return (Criteria) this;
        }

        public Criteria andSubquesidLessThan(String value) {
            addCriterion("subquesID <", value, "subquesid");
            return (Criteria) this;
        }

        public Criteria andSubquesidLessThanOrEqualTo(String value) {
            addCriterion("subquesID <=", value, "subquesid");
            return (Criteria) this;
        }

        public Criteria andSubquesidLike(String value) {
            addCriterion("subquesID like", value, "subquesid");
            return (Criteria) this;
        }

        public Criteria andSubquesidNotLike(String value) {
            addCriterion("subquesID not like", value, "subquesid");
            return (Criteria) this;
        }

        public Criteria andSubquesidIn(List<String> values) {
            addCriterion("subquesID in", values, "subquesid");
            return (Criteria) this;
        }

        public Criteria andSubquesidNotIn(List<String> values) {
            addCriterion("subquesID not in", values, "subquesid");
            return (Criteria) this;
        }

        public Criteria andSubquesidBetween(String value1, String value2) {
            addCriterion("subquesID between", value1, value2, "subquesid");
            return (Criteria) this;
        }

        public Criteria andSubquesidNotBetween(String value1, String value2) {
            addCriterion("subquesID not between", value1, value2, "subquesid");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNull() {
            addCriterion("answer is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNotNull() {
            addCriterion("answer is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerEqualTo(String value) {
            addCriterion("answer =", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotEqualTo(String value) {
            addCriterion("answer <>", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThan(String value) {
            addCriterion("answer >", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("answer >=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThan(String value) {
            addCriterion("answer <", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThanOrEqualTo(String value) {
            addCriterion("answer <=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLike(String value) {
            addCriterion("answer like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotLike(String value) {
            addCriterion("answer not like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerIn(List<String> values) {
            addCriterion("answer in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotIn(List<String> values) {
            addCriterion("answer not in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerBetween(String value1, String value2) {
            addCriterion("answer between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotBetween(String value1, String value2) {
            addCriterion("answer not between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnalysisIsNull() {
            addCriterion("analysis is null");
            return (Criteria) this;
        }

        public Criteria andAnalysisIsNotNull() {
            addCriterion("analysis is not null");
            return (Criteria) this;
        }

        public Criteria andAnalysisEqualTo(String value) {
            addCriterion("analysis =", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisNotEqualTo(String value) {
            addCriterion("analysis <>", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisGreaterThan(String value) {
            addCriterion("analysis >", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisGreaterThanOrEqualTo(String value) {
            addCriterion("analysis >=", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisLessThan(String value) {
            addCriterion("analysis <", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisLessThanOrEqualTo(String value) {
            addCriterion("analysis <=", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisLike(String value) {
            addCriterion("analysis like", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisNotLike(String value) {
            addCriterion("analysis not like", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisIn(List<String> values) {
            addCriterion("analysis in", values, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisNotIn(List<String> values) {
            addCriterion("analysis not in", values, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisBetween(String value1, String value2) {
            addCriterion("analysis between", value1, value2, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisNotBetween(String value1, String value2) {
            addCriterion("analysis not between", value1, value2, "analysis");
            return (Criteria) this;
        }

        public Criteria andAddpictureIsNull() {
            addCriterion("addPicture is null");
            return (Criteria) this;
        }

        public Criteria andAddpictureIsNotNull() {
            addCriterion("addPicture is not null");
            return (Criteria) this;
        }

        public Criteria andAddpictureEqualTo(String value) {
            addCriterion("addPicture =", value, "addpicture");
            return (Criteria) this;
        }

        public Criteria andAddpictureNotEqualTo(String value) {
            addCriterion("addPicture <>", value, "addpicture");
            return (Criteria) this;
        }

        public Criteria andAddpictureGreaterThan(String value) {
            addCriterion("addPicture >", value, "addpicture");
            return (Criteria) this;
        }

        public Criteria andAddpictureGreaterThanOrEqualTo(String value) {
            addCriterion("addPicture >=", value, "addpicture");
            return (Criteria) this;
        }

        public Criteria andAddpictureLessThan(String value) {
            addCriterion("addPicture <", value, "addpicture");
            return (Criteria) this;
        }

        public Criteria andAddpictureLessThanOrEqualTo(String value) {
            addCriterion("addPicture <=", value, "addpicture");
            return (Criteria) this;
        }

        public Criteria andAddpictureLike(String value) {
            addCriterion("addPicture like", value, "addpicture");
            return (Criteria) this;
        }

        public Criteria andAddpictureNotLike(String value) {
            addCriterion("addPicture not like", value, "addpicture");
            return (Criteria) this;
        }

        public Criteria andAddpictureIn(List<String> values) {
            addCriterion("addPicture in", values, "addpicture");
            return (Criteria) this;
        }

        public Criteria andAddpictureNotIn(List<String> values) {
            addCriterion("addPicture not in", values, "addpicture");
            return (Criteria) this;
        }

        public Criteria andAddpictureBetween(String value1, String value2) {
            addCriterion("addPicture between", value1, value2, "addpicture");
            return (Criteria) this;
        }

        public Criteria andAddpictureNotBetween(String value1, String value2) {
            addCriterion("addPicture not between", value1, value2, "addpicture");
            return (Criteria) this;
        }

        public Criteria andChangepictureIsNull() {
            addCriterion("changePicture is null");
            return (Criteria) this;
        }

        public Criteria andChangepictureIsNotNull() {
            addCriterion("changePicture is not null");
            return (Criteria) this;
        }

        public Criteria andChangepictureEqualTo(String value) {
            addCriterion("changePicture =", value, "changepicture");
            return (Criteria) this;
        }

        public Criteria andChangepictureNotEqualTo(String value) {
            addCriterion("changePicture <>", value, "changepicture");
            return (Criteria) this;
        }

        public Criteria andChangepictureGreaterThan(String value) {
            addCriterion("changePicture >", value, "changepicture");
            return (Criteria) this;
        }

        public Criteria andChangepictureGreaterThanOrEqualTo(String value) {
            addCriterion("changePicture >=", value, "changepicture");
            return (Criteria) this;
        }

        public Criteria andChangepictureLessThan(String value) {
            addCriterion("changePicture <", value, "changepicture");
            return (Criteria) this;
        }

        public Criteria andChangepictureLessThanOrEqualTo(String value) {
            addCriterion("changePicture <=", value, "changepicture");
            return (Criteria) this;
        }

        public Criteria andChangepictureLike(String value) {
            addCriterion("changePicture like", value, "changepicture");
            return (Criteria) this;
        }

        public Criteria andChangepictureNotLike(String value) {
            addCriterion("changePicture not like", value, "changepicture");
            return (Criteria) this;
        }

        public Criteria andChangepictureIn(List<String> values) {
            addCriterion("changePicture in", values, "changepicture");
            return (Criteria) this;
        }

        public Criteria andChangepictureNotIn(List<String> values) {
            addCriterion("changePicture not in", values, "changepicture");
            return (Criteria) this;
        }

        public Criteria andChangepictureBetween(String value1, String value2) {
            addCriterion("changePicture between", value1, value2, "changepicture");
            return (Criteria) this;
        }

        public Criteria andChangepictureNotBetween(String value1, String value2) {
            addCriterion("changePicture not between", value1, value2, "changepicture");
            return (Criteria) this;
        }

        public Criteria andPassrateIsNull() {
            addCriterion("passrate is null");
            return (Criteria) this;
        }

        public Criteria andPassrateIsNotNull() {
            addCriterion("passrate is not null");
            return (Criteria) this;
        }

        public Criteria andPassrateEqualTo(Double value) {
            addCriterion("passrate =", value, "passrate");
            return (Criteria) this;
        }

        public Criteria andPassrateNotEqualTo(Double value) {
            addCriterion("passrate <>", value, "passrate");
            return (Criteria) this;
        }

        public Criteria andPassrateGreaterThan(Double value) {
            addCriterion("passrate >", value, "passrate");
            return (Criteria) this;
        }

        public Criteria andPassrateGreaterThanOrEqualTo(Double value) {
            addCriterion("passrate >=", value, "passrate");
            return (Criteria) this;
        }

        public Criteria andPassrateLessThan(Double value) {
            addCriterion("passrate <", value, "passrate");
            return (Criteria) this;
        }

        public Criteria andPassrateLessThanOrEqualTo(Double value) {
            addCriterion("passrate <=", value, "passrate");
            return (Criteria) this;
        }

        public Criteria andPassrateIn(List<Double> values) {
            addCriterion("passrate in", values, "passrate");
            return (Criteria) this;
        }

        public Criteria andPassrateNotIn(List<Double> values) {
            addCriterion("passrate not in", values, "passrate");
            return (Criteria) this;
        }

        public Criteria andPassrateBetween(Double value1, Double value2) {
            addCriterion("passrate between", value1, value2, "passrate");
            return (Criteria) this;
        }

        public Criteria andPassrateNotBetween(Double value1, Double value2) {
            addCriterion("passrate not between", value1, value2, "passrate");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNull() {
            addCriterion("keyword is null");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNotNull() {
            addCriterion("keyword is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordEqualTo(String value) {
            addCriterion("keyword =", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotEqualTo(String value) {
            addCriterion("keyword <>", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThan(String value) {
            addCriterion("keyword >", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("keyword >=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThan(String value) {
            addCriterion("keyword <", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThanOrEqualTo(String value) {
            addCriterion("keyword <=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLike(String value) {
            addCriterion("keyword like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotLike(String value) {
            addCriterion("keyword not like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordIn(List<String> values) {
            addCriterion("keyword in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotIn(List<String> values) {
            addCriterion("keyword not in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordBetween(String value1, String value2) {
            addCriterion("keyword between", value1, value2, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotBetween(String value1, String value2) {
            addCriterion("keyword not between", value1, value2, "keyword");
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