package com.jueee.item12;

import com.google.auto.value.AutoValue;

public class Item12Example02 {

    public static void main(String[] args) {
        PhoneNumber2 number1 = PhoneNumber2.create(707, 867, 5309);
        System.out.println(number1);    // PhoneNumber2{areaCode=707, prefix=867, lineNum=5309}
        System.out.println(number1.toString());    // PhoneNumber2{areaCode=707, prefix=867, lineNum=5309}
    }
}
/**
 *  在这里需要注意的是：
 *  1、实体类中AutoValue的前缀不能改变，否则编译不会通过；
 *  2、字段名称必须对应一致，实际参数列表和形参列表一致，否则编译不过；
 *	3、AutoValue_PhoneNumber2 是根据AutoValue的命名格式AutoValue_类名来命名的
 *	@author hzweiyongqiang
 */
@AutoValue
abstract class PhoneNumber2 {

    public static PhoneNumber2 create(int areaCode, int prefix, int lineNum) {
        return new AutoValue_PhoneNumber2(areaCode, prefix, lineNum);
    }
    
    public abstract int areaCode();
    public abstract int prefix();
    public abstract int lineNum();
}