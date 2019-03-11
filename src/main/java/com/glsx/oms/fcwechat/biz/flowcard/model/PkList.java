package com.glsx.oms.fcwechat.biz.flowcard.model;

public class PkList
{
    
    private int flowpkgtype;
    
    private String flowpkgname;
    
    private int relation_id;
    
    private String price;
    
    private String pkgalias;
    
    private String pkgdesc;
    
    private int flowserv_type;
    
    private String total_flow;
    
    // 流量单位（G/M）
    private String flow_unit;
    
    //是否月底清零
    private int is_month_clean;
    
    //月付日期
    private int flowserv_pay_date;
    
    // 有效期周期
    private int valid_cycle;
    
    private String per_cycle_flow;
    
    private String charge_cycle;
    
    //计费周期单位（0：天/ 1：月 /2：年）
    private String charge_mode;
    
    // 有效期周期单位 （0：天 /1：月 2:年）
    private int valid_cycle_unit;
    
    //是否无限流量（0：有限流量 1：无限流量）
    private int is_unlimit_flow;
    
    
    public int getFlowserv_pay_date() {
		return flowserv_pay_date;
	}

	public void setFlowserv_pay_date(int flowserv_pay_date) {
		this.flowserv_pay_date = flowserv_pay_date;
	}

	public int getIs_month_clean() {
		return is_month_clean;
	}

	public void setIs_month_clean(int is_month_clean) {
		this.is_month_clean = is_month_clean;
	}

	public int getFlowserv_type()
    {
        return flowserv_type;
    }
    
    public void setFlowserv_type(int flowserv_type)
    {
        this.flowserv_type = flowserv_type;
    }
    
    public int getFlowpkgtype()
    {
        return flowpkgtype;
    }
    
    public void setFlowpkgtype(int flowpkgtype)
    {
        this.flowpkgtype = flowpkgtype;
    }
    
    public String getFlowpkgname()
    {
        return flowpkgname;
    }
    
    public void setFlowpkgname(String flowpkgname)
    {
        this.flowpkgname = flowpkgname;
    }
    
    public int getRelation_id()
    {
        return relation_id;
    }
    
    public void setRelation_id(int relation_id)
    {
        this.relation_id = relation_id;
    }
    
    public String getPrice()
    {
        return price;
    }
    
    public void setPrice(String price)
    {
        this.price = price;
    }
    
    public String getPkgalias()
    {
        return pkgalias;
    }
    
    public void setPkgalias(String pkgalias)
    {
        this.pkgalias = pkgalias;
    }
    
    public String getPkgdesc()
    {
        return pkgdesc;
    }
    
    public void setPkgdesc(String pkgdesc)
    {
        this.pkgdesc = pkgdesc;
    }
    
    public int getValid_cycle()
    {
        return valid_cycle;
    }
    
    public void setValid_cycle(int valid_cycle)
    {
        this.valid_cycle = valid_cycle;
    }
    
    public int getValid_cycle_unit()
    {
        return valid_cycle_unit;
    }
    
    public void setValid_cycle_unit(int valid_cycle_unit)
    {
        this.valid_cycle_unit = valid_cycle_unit;
    }
    
    public String getTotal_flow()
    {
        return total_flow;
    }
    
    public void setTotal_flow(String total_flow)
    {
        this.total_flow = total_flow;
    }
    
    public String getFlow_unit()
    {
        return flow_unit;
    }
    
    public void setFlow_unit(String flow_unit)
    {
        this.flow_unit = flow_unit;
    }
    
    /**
     * 得到属性字符串
     * 
     * @return String 属性字符串
     */
    public String toString()
    {
        String line = System.getProperty("line.separator");
        StringBuffer sb = new StringBuffer("{");
        sb.append(line);
        sb.append("flowserv_type=").append((this.flowserv_type)).append(line);
        sb.append("flowpkgtype=").append((this.flowpkgtype)).append(line);
        sb.append("flowpkgname=").append((this.flowpkgname)).append(line);
        sb.append("relation_id=").append((this.relation_id)).append(line);
        sb.append("price=").append((this.price)).append(line);
        sb.append("pkgalias=").append((this.pkgalias)).append(line);
        sb.append("pkgdesc=").append((this.pkgdesc)).append(line);
        sb.append("valid_cycle=").append((this.valid_cycle)).append(line);
        sb.append("valid_cycle_unit=").append((this.valid_cycle_unit)).append(line);
        sb.append("total_flow=").append((this.total_flow)).append(line);
        sb.append("flow_unit=").append((this.flow_unit)).append(line);
        sb.append("}");
        return sb.toString();
    }

    public int getIs_unlimit_flow()
    {
        return is_unlimit_flow;
    }

    public void setIs_unlimit_flow(int is_unlimit_flow)
    {
        this.is_unlimit_flow = is_unlimit_flow;
    }

    public String getPer_cycle_flow()
    {
        return per_cycle_flow;
    }

    public void setPer_cycle_flow(String per_cycle_flow)
    {
        this.per_cycle_flow = per_cycle_flow;
    }

    public String getCharge_cycle()
    {
        return charge_cycle;
    }

    public void setCharge_cycle(String charge_cycle)
    {
        this.charge_cycle = charge_cycle;
    }

    public String getCharge_mode()
    {
        return charge_mode;
    }

    public void setCharge_mode(String charge_mode)
    {
        this.charge_mode = charge_mode;
    }
    
}