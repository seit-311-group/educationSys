package cn.sysu.educationSys.utils;

/**
 * 用于保存环境变量
 */
public class StaticVariables {

    public static final String TEST_KEY = "true";

    public static final String QUESTION_MISMATCHED = "没有找到该问题";        // 问题失配
    public static final String NO_SUBQUESTIONs = "没有相关子问题";        // 没有相关子问题

    public static final String UPLOAD_SUCCESS = "上传成功";        // 没有相关子问题
    public static final String UPLOAD_FALSE = "上传失败";        // 没有相关子问题

    // 问答系统相关
    public static final int FIND_MANY_QUESTION = 5;        // 找到多少个问题
    public static final double SIMILARITY_MATCHING_THRESHOLD = 0.8; // 直接返回答案的阈值
    public static final String DIRECT_ANSWER = "直接返回答案";
    public static final double MISMATCHED_THRESHOLD = 0.1; // 问题失配的阈值





}
