package com.wuhunyu.utils;

/**
 * sql解析器
 *
 * @author gongzhiqiang
 * @date 2022/11/28 17:40
 **/

public class SqlParse {

    /**
     * create table
     */
    private static final String CREATE_TABLE = "create table";

    /**
     * 左括号
     */
    private static final String LEFT_BRACKET = "(";

    /**
     * 右括号
     */
    private static final String RIGHT_BRACKET = ")";

    /**
     * 逗号
     */
    private static final String COMMA = ",";

    /**
     * 注释
     */
    private static final String COMMENT = "comment";

    // comment\s+'([\S ]+)'

    public static void parse(String createTableSql) {
        // 空字符串
        if (createTableSql == null || createTableSql.trim().length() == 0) {
            return;
        }
        // 去除换行符号
        createTableSql = createTableSql.replaceAll("\\r\\n", "")
                .replaceAll("\\n", "");
        // 读取表名称
        SqlParse.parseTableNameAndTableComment(createTableSql);
    }

    private static void parseTableNameAndTableComment(String createTableSql) {
        // 表名称
        int tableNameStart = createTableSql.indexOf(CREATE_TABLE);
        int tableNameEnd = createTableSql.indexOf(LEFT_BRACKET);
        String tableName = createTableSql.substring(tableNameStart + CREATE_TABLE.length(), tableNameEnd)
                .trim();

        // 表注释
        int tableCommentStart = createTableSql.lastIndexOf(COMMENT);
        String tableCommentStr = createTableSql.substring(tableCommentStart);
    }

    public static void main(String[] args) {
        SqlParse.parse("create table sys_message_send_record\n" +
                "(\n" +
                "    id                bigint primary key comment 'id',\n" +
                "    message_notice_id bigint   not null comment '系统消息id',\n" +
                "    notice_status     tinyint  not null comment '提醒状态(0: 未发送; 1: 已发送)',\n" +
                "\n" +
                "    company_id        char(32) not null comment '公司id',\n" +
                "    remark            varchar(300)      default '' not null comment '备注',\n" +
                "    del_flag          tinyint  not null default 0 comment '逻辑删除标识(0: 正常; 1: 已被删除)',\n" +
                "    create_time       datetime not null comment '创建时间',\n" +
                "    create_by         bigint   not null comment '创建人',\n" +
                "    update_time       datetime null comment '修改时间',\n" +
                "    update_by         bigint   null comment '修改人'\n" +
                ") comment '系统消息-发送记录';");
    }

}
