// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;

import java.util.Map;

// Referenced classes of package argo.jdom:
//            LeafFunctor, JsonNodeType, JsonNode

final class JsonNodeSelectors_Object extends LeafFunctor
{

    JsonNodeSelectors_Object()
    {
    }

    public boolean func_27070_a(JsonNode p_27070_1_)
    {
        return JsonNodeType.OBJECT == p_27070_1_.func_27218_a();
    }

    public String func_27060_a()
    {
        return "A short form object";
    }

    public Map func_27071_b(JsonNode p_27071_1_)
    {
        return p_27071_1_.func_27214_c();
    }

    public String toString()
    {
        return "an object";
    }

    public Object func_27063_c(Object p_27063_1_)
    {
        return func_27071_b((JsonNode)p_27063_1_);
    }

    public boolean func_27058_a(Object p_27058_1_)
    {
        return func_27070_a((JsonNode)p_27058_1_);
    }
}
