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

import org.clank.java.*;
import static org.clank.java.built_in.__builtin_va_arg;
import org.clank.support.*;
import static org.clank.support.Native.$tryClone;
import org.clank.support.aliases.*;
import org.llvm.adt.aliases.*;


// values - For custom data types, allow specifying a group of values together
// as the values that go into the mapping that the option handler uses.  Note
// that the values list must always have a 0 at the end of the list to indicate
// that the list has ended.
//
/*template <class DataType> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::cl::ValuesClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 567,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 504,
 FQN="llvm::cl::ValuesClass", NM="_ZN4llvm2cl11ValuesClassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl11ValuesClassE")
//</editor-fold>
public class ValuesClass</*class*/ DataType> /* implements Destructors.ClassWithDestructor*/ {
  // Use a vector instead of a map, because the lists should be short,
  // the overhead is less, and most importantly, it keeps them in the order
  // inserted so we can print our option out nicely.
  private final SmallVector<std.pairTypeType</*const*/char$ptr/*char P*/ , std.pairTypeType<DataType, /*const*/char$ptr/*char P*/>>> Values = new SmallVector<std.pairTypeType<char$ptr, std.pairTypeType<DataType, char$ptr>>>(8, 
          new std.pairTypeType</*const*/char$ptr/*char P*/ , std.pairTypeType<DataType, /*const*/char$ptr/*char P*/>>((char$ptr)null, new std.pairTypeType<DataType, /*const*/char$ptr/*char P*/>((DataType)null, (char$ptr)null)));
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::ValuesClass::processValues">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 572,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 509,
   FQN="llvm::cl::ValuesClass::processValues", NM="_ZN4llvm2cl11ValuesClass13processValuesEPc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl11ValuesClass13processValuesEPc")
  //</editor-fold>
  private void processValues(char$ptr/*char P*/ Vals) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::ValuesClass::ValuesClass<DataType>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*char$ptr=>type$ptr for builtin_va-funcs*/,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 575,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 512,
   FQN="llvm::cl::ValuesClass::ValuesClass<DataType>", NM="_ZN4llvm2cl11ValuesClassC1EPKcT_S3_Pc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl11ValuesClassC1EPKcT_S3_Pc")
  //</editor-fold>
  public ValuesClass(/*const*/char$ptr/*char P*/ EnumName, DataType Val, /*const*/char$ptr/*char P*/ Desc, 
      type$ptr/*char P*/ ValueArgs) {
    // Insert the first value, which is required.
    Values.push_back(std.make_pair(EnumName, std.make_pair(Val, Desc)));
    {
      
      // Process the varargs portion of the values...
      /*const*/char$ptr/*char P*/ enumName;
      while (Native.$bool((/*P*/ enumName = $tryClone(__builtin_va_arg(ValueArgs, /*const*/char$ptr/*char P*/ .class))))) {
        DataType EnumVal = ((/*static_cast*/DataType)(__builtin_va_arg(ValueArgs, Integer.class)));
        /*const*/char$ptr/*char P*/ EnumDesc = $tryClone(__builtin_va_arg(ValueArgs, /*const*/char$ptr/*char P*/ .class));
        Values.push_back(std.make_pair(enumName,  // Add value to value map
                std.make_pair(EnumVal, EnumDesc)));
      }
    }
  }

  
  /*template <class Opt> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::ValuesClass::apply">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 589,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 526,
   FQN="llvm::cl::ValuesClass::apply", NM="Tpl__ZNK4llvm2cl11ValuesClass5applyERT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=Tpl__ZNK4llvm2cl11ValuesClass5applyERT_")
  //</editor-fold>
  public </*class*/ Opt extends Option> void apply(final Opt /*&*/ O) /*const*/ {
    for (/*size_t*/int i = 0, e = Values.size(); i != e; ++i)  {
      O.getParser().addLiteralOption(O, Values.$at(i).first, Values.$at(i).second.first, 
          Values.$at(i).second.second);
    }
  }

  
  @Override public String toString() {
    return "" + "Values=" + Values; // NOI18N
  }
}
