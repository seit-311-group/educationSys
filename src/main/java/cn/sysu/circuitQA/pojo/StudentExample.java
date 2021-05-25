package cn.sysu.circuitQA.pojo;

import java.util.ArrayList;
import java.util.List;

public class StudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStudentnameIsNull() {
            addCriterion("studentName is null");
            return (Criteria) this;
        }

        public Criteria andStudentnameIsNotNull() {
            addCriterion("studentName is not null");
            return (Criteria) this;
        }

        public Criteria andStudentnameEqualTo(String value) {
            addCriterion("studentName =", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotEqualTo(String value) {
            addCriterion("studentName <>", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameGreaterThan(String value) {
            addCriterion("studentName >", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameGreaterThanOrEqualTo(String value) {
            addCriterion("studentName >=", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLessThan(String value) {
            addCriterion("studentName <", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLessThanOrEqualTo(String value) {
            addCriterion("studentName <=", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLike(String value) {
            addCriterion("studentName like", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotLike(String value) {
            addCriterion("studentName not like", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameIn(List<String> values) {
            addCriterion("studentName in", values, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotIn(List<String> values) {
            addCriterion("studentName not in", values, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameBetween(String value1, String value2) {
            addCriterion("studentName between", value1, value2, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotBetween(String value1, String value2) {
            addCriterion("studentName not between", value1, value2, "studentname");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andClassandgradeIsNull() {
            addCriterion("classAndGrade is null");
            return (Criteria) this;
        }

        public Criteria andClassandgradeIsNotNull() {
            addCriterion("classAndGrade is not null");
            return (Criteria) this;
        }

        public Criteria andClassandgradeEqualTo(String value) {
            addCriterion("classAndGrade =", value, "classandgrade");
            return (Criteria) this;
        }

        public Criteria andClassandgradeNotEqualTo(String value) {
            addCriterion("classAndGrade <>", value, "classandgrade");
            return (Criteria) this;
        }

        public Criteria andClassandgradeGreaterThan(String value) {
            addCriterion("classAndGrade >", value, "classandgrade");
            return (Criteria) this;
        }

        public Criteria andClassandgradeGreaterThanOrEqualTo(String value) {
            addCriterion("classAndGrade >=", value, "classandgrade");
            return (Criteria) this;
        }

        public Criteria andClassandgradeLessThan(String value) {
            addCriterion("classAndGrade <", value, "classandgrade");
            return (Criteria) this;
        }

        public Criteria andClassandgradeLessThanOrEqualTo(String value) {
            addCriterion("classAndGrade <=", value, "classandgrade");
            return (Criteria) this;
        }

        public Criteria andClassandgradeLike(String value) {
            addCriterion("classAndGrade like", value, "classandgrade");
            return (Criteria) this;
        }

        public Criteria andClassandgradeNotLike(String value) {
            addCriterion("classAndGrade not like", value, "classandgrade");
            return (Criteria) this;
        }

        public Criteria andClassandgradeIn(List<String> values) {
            addCriterion("classAndGrade in", values, "classandgrade");
            return (Criteria) this;
        }

        public Criteria andClassandgradeNotIn(List<String> values) {
            addCriterion("classAndGrade not in", values, "classandgrade");
            return (Criteria) this;
        }

        public Criteria andClassandgradeBetween(String value1, String value2) {
            addCriterion("classAndGrade between", value1, value2, "classandgrade");
            return (Criteria) this;
        }

        public Criteria andClassandgradeNotBetween(String value1, String value2) {
            addCriterion("classAndGrade not between", value1, value2, "classandgrade");
            return (Criteria) this;
        }

        public Criteria andQuerykeywordsIsNull() {
            addCriterion("querykeywords is null");
            return (Criteria) this;
        }

        public Criteria andQuerykeywordsIsNotNull() {
            addCriterion("querykeywords is not null");
            return (Criteria) this;
        }

        public Criteria andQuerykeywordsEqualTo(String value) {
            addCriterion("querykeywords =", value, "querykeywords");
            return (Criteria) this;
        }

        public Criteria andQuerykeywordsNotEqualTo(String value) {
            addCriterion("querykeywords <>", value, "querykeywords");
            return (Criteria) this;
        }

        public Criteria andQuerykeywordsGreaterThan(String value) {
            addCriterion("querykeywords >", value, "querykeywords");
            return (Criteria) this;
        }

        public Criteria andQuerykeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("querykeywords >=", value, "querykeywords");
            return (Criteria) this;
        }

        public Criteria andQuerykeywordsLessThan(String value) {
            addCriterion("querykeywords <", value, "querykeywords");
            return (Criteria) this;
        }

        public Criteria andQuerykeywordsLessThanOrEqualTo(String value) {
            addCriterion("querykeywords <=", value, "querykeywords");
            return (Criteria) this;
        }

        public Criteria andQuerykeywordsLike(String value) {
            addCriterion("querykeywords like", value, "querykeywords");
            return (Criteria) this;
        }

        public Criteria andQuerykeywordsNotLike(String value) {
            addCriterion("querykeywords not like", value, "querykeywords");
            return (Criteria) this;
        }

        public Criteria andQuerykeywordsIn(List<String> values) {
            addCriterion("querykeywords in", values, "querykeywords");
            return (Criteria) this;
        }

        public Criteria andQuerykeywordsNotIn(List<String> values) {
            addCriterion("querykeywords not in", values, "querykeywords");
            return (Criteria) this;
        }

        public Criteria andQuerykeywordsBetween(String value1, String value2) {
            addCriterion("querykeywords between", value1, value2, "querykeywords");
            return (Criteria) this;
        }

        public Criteria andQuerykeywordsNotBetween(String value1, String value2) {
            addCriterion("querykeywords not between", value1, value2, "querykeywords");
            return (Criteria) this;
        }

        public Criteria andAnswerkeywordsIsNull() {
            addCriterion("answerkeywords is null");
            return (Criteria) this;
        }

        public Criteria andAnswerkeywordsIsNotNull() {
            addCriterion("answerkeywords is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerkeywordsEqualTo(String value) {
            addCriterion("answerkeywords =", value, "answerkeywords");
            return (Criteria) this;
        }

        public Criteria andAnswerkeywordsNotEqualTo(String value) {
            addCriterion("answerkeywords <>", value, "answerkeywords");
            return (Criteria) this;
        }

        public Criteria andAnswerkeywordsGreaterThan(String value) {
            addCriterion("answerkeywords >", value, "answerkeywords");
            return (Criteria) this;
        }

        public Criteria andAnswerkeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("answerkeywords >=", value, "answerkeywords");
            return (Criteria) this;
        }

        public Criteria andAnswerkeywordsLessThan(String value) {
            addCriterion("answerkeywords <", value, "answerkeywords");
            return (Criteria) this;
        }

        public Criteria andAnswerkeywordsLessThanOrEqualTo(String value) {
            addCriterion("answerkeywords <=", value, "answerkeywords");
            return (Criteria) this;
        }

        public Criteria andAnswerkeywordsLike(String value) {
            addCriterion("answerkeywords like", value, "answerkeywords");
            return (Criteria) this;
        }

        public Criteria andAnswerkeywordsNotLike(String value) {
            addCriterion("answerkeywords not like", value, "answerkeywords");
            return (Criteria) this;
        }

        public Criteria andAnswerkeywordsIn(List<String> values) {
            addCriterion("answerkeywords in", values, "answerkeywords");
            return (Criteria) this;
        }

        public Criteria andAnswerkeywordsNotIn(List<String> values) {
            addCriterion("answerkeywords not in", values, "answerkeywords");
            return (Criteria) this;
        }

        public Criteria andAnswerkeywordsBetween(String value1, String value2) {
            addCriterion("answerkeywords between", value1, value2, "answerkeywords");
            return (Criteria) this;
        }

        public Criteria andAnswerkeywordsNotBetween(String value1, String value2) {
            addCriterion("answerkeywords not between", value1, value2, "answerkeywords");
            return (Criteria) this;
        }

        public Criteria andPassedquestionIsNull() {
            addCriterion("passedquestion is null");
            return (Criteria) this;
        }

        public Criteria andPassedquestionIsNotNull() {
            addCriterion("passedquestion is not null");
            return (Criteria) this;
        }

        public Criteria andPassedquestionEqualTo(String value) {
            addCriterion("passedquestion =", value, "passedquestion");
            return (Criteria) this;
        }

        public Criteria andPassedquestionNotEqualTo(String value) {
            addCriterion("passedquestion <>", value, "passedquestion");
            return (Criteria) this;
        }

        public Criteria andPassedquestionGreaterThan(String value) {
            addCriterion("passedquestion >", value, "passedquestion");
            return (Criteria) this;
        }

        public Criteria andPassedquestionGreaterThanOrEqualTo(String value) {
            addCriterion("passedquestion >=", value, "passedquestion");
            return (Criteria) this;
        }

        public Criteria andPassedquestionLessThan(String value) {
            addCriterion("passedquestion <", value, "passedquestion");
            return (Criteria) this;
        }

        public Criteria andPassedquestionLessThanOrEqualTo(String value) {
            addCriterion("passedquestion <=", value, "passedquestion");
            return (Criteria) this;
        }

        public Criteria andPassedquestionLike(String value) {
            addCriterion("passedquestion like", value, "passedquestion");
            return (Criteria) this;
        }

        public Criteria andPassedquestionNotLike(String value) {
            addCriterion("passedquestion not like", value, "passedquestion");
            return (Criteria) this;
        }

        public Criteria andPassedquestionIn(List<String> values) {
            addCriterion("passedquestion in", values, "passedquestion");
            return (Criteria) this;
        }

        public Criteria andPassedquestionNotIn(List<String> values) {
            addCriterion("passedquestion not in", values, "passedquestion");
            return (Criteria) this;
        }

        public Criteria andPassedquestionBetween(String value1, String value2) {
            addCriterion("passedquestion between", value1, value2, "passedquestion");
            return (Criteria) this;
        }

        public Criteria andPassedquestionNotBetween(String value1, String value2) {
            addCriterion("passedquestion not between", value1, value2, "passedquestion");
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