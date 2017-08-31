/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.llvm.cl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.literal_constants.$;
import org.llvm.adt.StringRef;
import org.llvm.adt.Twine;
import org.llvm.adt.aliases.SmallVector;
import static org.llvm.cl.ClGlobals.AddLiteralOption;
import org.llvm.support.llvm;


// Default parser implementation - This implementation depends on having a
// mapping of recognized options to values of some sort.  In addition to this,
// each entry in the mapping also tracks a help message that is printed with the
// command line option for -help.  Because this is a simple mapping parser, the
// data type can be any unsupported type.
//
/*template <class DataType> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::cl::parser">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 713,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 650,
 FQN="llvm::cl::parser", NM="_ZN4llvm2cl6parserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6parserE")
//</editor-fold>
public class parser</*class*/ DataType>  extends /*public*/ generic_parser_base implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser::OptionInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 715,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 652,
   FQN="llvm::cl::parser::OptionInfo", NM="_ZN4llvm2cl6parser10OptionInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6parser10OptionInfoE")
  //</editor-fold>
  protected static class OptionInfo</*class*/ DataType> extends /*public*/ generic_parser_base.GenericOptionInfo {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser::OptionInfo::OptionInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 717,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 654,
     FQN="llvm::cl::parser::OptionInfo::OptionInfo", NM="_ZN4llvm2cl6parser10OptionInfoC1EPKcT_S4_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6parser10OptionInfoC1EPKcT_S4_")
    //</editor-fold>
    public OptionInfo(/*const*/char$ptr/*char P*/ name, DataType v, /*const*/char$ptr/*char P*/ helpStr) {
      // : GenericOptionInfo(name, helpStr), V(v) 
      //START JInit
      /*ParenListExpr*/super(name, helpStr);
      this.V = /*ParenListExpr*/new OptionValue<DataType>(v);
      //END JInit
    }

    public OptionValue<DataType> V;
    
    @Override public String toString() {
      return "" + "V=" + V // NOI18N
                + super.toString(); // NOI18N
    }
  };
  protected final SmallVector<OptionInfo> Values;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser::parser<DataType>">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 724,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 661,
   FQN="llvm::cl::parser::parser<DataType>", NM="_ZN4llvm2cl6parserC1ERNS0_6OptionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6parserC1ERNS0_6OptionE")
  //</editor-fold>
  public parser(final Option /*&*/ O) {
    // : generic_parser_base(O) 
    //START JInit
    /*ParenListExpr*/super(O);
    //END JInit
    this.Values = new SmallVector<OptionInfo>(0, (OptionInfo/*P*/)null); // JAVA: is Pointer OK here? Let's hope
  }

  // JAVA: typedef DataType parser_data_type
//  public final class parser_data_type extends DataType{ };
  
  // Implement virtual functions needed by generic_parser_base
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser::getNumOptions">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 728,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 665,
   FQN="llvm::cl::parser::getNumOptions", NM="_ZNK4llvm2cl6parser13getNumOptionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl6parser13getNumOptionsEv")
  //</editor-fold>
  @Override public /*uint*/int getNumOptions() /*const*//* override*/ {
    return Values.size();//new /*uint*/int(Values.size());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser::getOption">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 729,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 666,
   FQN="llvm::cl::parser::getOption", NM="_ZNK4llvm2cl6parser9getOptionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl6parser9getOptionEj")
  //</editor-fold>
  @Override public /*const*/char$ptr/*char P*/ getOption(/*uint*/int N) /*const*//* override*/ {
    return Values.$at(N).Name;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser::getDescription">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 730,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 667,
   FQN="llvm::cl::parser::getDescription", NM="_ZNK4llvm2cl6parser14getDescriptionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl6parser14getDescriptionEj")
  //</editor-fold>
  @Override public /*const*/char$ptr/*char P*/ getDescription(/*uint*/int N) /*const*//* override*/ {
    return Values.$at(N).HelpStr;
  }

  
  // getOptionValue - Return the value of option name N.
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser::getOptionValue">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 735,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 672,
   FQN="llvm::cl::parser::getOptionValue", NM="_ZNK4llvm2cl6parser14getOptionValueEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl6parser14getOptionValueEj")
  //</editor-fold>
  @Override public /*const*/ GenericOptionValue /*&*/ getOptionValue(/*uint*/int N) /*const*//* override*/ {
    return Values.$at(N).V;
  }

  
  // parse - Return true on error.
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser::parse">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 740,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 677,
   FQN="llvm::cl::parser::parse", NM="_ZN4llvm2cl6parser5parseERNS0_6OptionENS_9StringRefES4_RT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6parser5parseERNS0_6OptionENS_9StringRefES4_RT_")
  //</editor-fold>
  public boolean parse(final Option /*&*/ O, StringRef ArgName, StringRef Arg, final type$ref<DataType> /*&*/ V) {
    StringRef ArgVal/*J*/= new StringRef();
    if (Owner.hasArgStr()) {
      ArgVal.$assign(Arg);
    } else {
      ArgVal.$assign(ArgName);
    }
    
    for (/*size_t*/int i = 0, e = Values.size(); i != e; ++i)  {
      if (Native.$eq(Values.$at(i).Name, ArgVal)) {
        V.$set((DataType)Values.$at(i).V.getValue());
        return false;
      }
    }
    
    return O.error(llvm.$add_Twine$C(
            llvm.$add_char$ptr$C_StringRef$C(/*KEEP_STR*/$("Cannot find option named '"), ArgVal), 
            new Twine(/*KEEP_STR*/"'!")));
  }

  
  /// addLiteralOption - Add an entry to the mapping table.
  ///
  /*template <class DT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser::addLiteralOption">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 759,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 695,
   FQN="llvm::cl::parser::addLiteralOption", NM="Tpl__ZN4llvm2cl6parser16addLiteralOptionEPKcRKT_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=Tpl__ZN4llvm2cl6parser16addLiteralOptionEPKcRKT_S3_")
  //</editor-fold>
  public </*class*/ DT> void addLiteralOption(/*const*/char$ptr/*char P*/ Name, final /*const*/ DT /*&*/ V, /*const*/char$ptr/*char P*/ HelpStr) {
    assert Native.$bool(Native.$eq(findOption(Name), Values.size())) : "Option already exists!";
    OptionInfo X/*J*/= /*ParenList*/new OptionInfo(Name, ((/*static_cast*/DataType)(V)), HelpStr);
    Values.push_back(X);
    AddLiteralOption(Owner, Name);
  }

  
  /// removeLiteralOption - Remove the specified option.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser::removeLiteralOption">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 768,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 705,
   FQN="llvm::cl::parser::removeLiteralOption", NM="_ZN4llvm2cl6parser19removeLiteralOptionEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6parser19removeLiteralOptionEPKc")
  //</editor-fold>
  public void removeLiteralOption(/*const*/char$ptr/*char P*/ Name) {
    /*uint*/int N = findOption(Name);
    assert Native.$bool(Native.$noteq(N, Values.size())) : "Option not found!";
    Values.erase(Native.$add(Values.begin(), N));
  }

  
  @Override public String toString() {
    return "" + "Values=" + Values // NOI18N
              + super.toString(); // NOI18N
  }
}
