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
package org.clang.clangc;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.llvm.cl.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clank.java.stdimpl.aliases.*;
import org.clang.clangc.CXStringGlobals.*;
import org.clang.clangc.spi.CXStringGlobalsImplementation;
import org.openide.util.Lookup;


//<editor-fold defaultstate="collapsed" desc="static type CXStringGlobals">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXString.cpp -nm=_CXString;_CXStringSet;_Z16clang_getCString;_Z19clang_disposeString;_Z22clang_disposeStringSet; -static-type=CXStringGlobals -package=org.clang.clangc")
//</editor-fold>
public final class CXStringGlobals {
  private static final class Holder {
    private static final CXStringGlobalsImplementation Impl;
    static {
      CXStringGlobalsImplementation service = Lookup.getDefault().lookup(CXStringGlobalsImplementation.class);
      if (service == null) {
        service = new CXStringGlobalsImplementation() {};
      }
      Impl = service;
    }
  }
  
  private static CXStringGlobalsImplementation $Impl() {
    return Holder.Impl;
  }

/**
* \defgroup CINDEX_STRING String manipulation routines
* \ingroup CINDEX
*
* @{
*/

/**
* \brief A character string.
*
* The \c CXString type is used to return strings from the interface when
* the ownership of that string might differ from one call to the next.
* Use \c clang_getCString() to retrieve the string data and, once finished
* with the string data, call \c clang_disposeString() to free the string.
*/
//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang-c/CXString.h", line = 38,
 FQN="(anonymous)", NM="_CXString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXString.cpp -nm=_CXString")
//</editor-fold>
public class/*struct*/ CXString {
  public /*const*/Object/*void P*/ data;
  public /*uint*/int private_flags;
  //<editor-fold defaultstate="collapsed" desc="(anonymous struct)::">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang-c/CXString.h", line = 38,
   FQN="(anonymous struct)::", NM="_ZN8CXStringC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXString.cpp -nm=_ZN8CXStringC1Ev")
  //</editor-fold>
  public /*inline*/ CXString() {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous struct)::">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang-c/CXString.h", line = 38,
   FQN="(anonymous struct)::", NM="_ZN8CXStringC1ERKS_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXString.cpp -nm=_ZN8CXStringC1ERKS_")
  //</editor-fold>
  public /*inline*/ CXString(/*const*/ CXString /*&*/ $Prm0) {
    // : data(.data), private_flags(.private_flags) 
    //START JInit
    this.data = $Prm0.data;
    this.private_flags = $Prm0.private_flags;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous struct)::">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang-c/CXString.h", line = 38,
   FQN="(anonymous struct)::", NM="_ZN8CXStringC1EOS_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXString.cpp -nm=_ZN8CXStringC1EOS_")
  //</editor-fold>
  public /*inline*/ CXString(JD$Move _dparam, CXString /*&&*/$Prm0) {
    // : data(static_cast<CXString &&>().data), private_flags(static_cast<CXString &&>().private_flags) 
    //START JInit
    this.data = $Prm0.data;
    this.private_flags = $Prm0.private_flags;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous struct)::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang-c/CXString.h", line = 38,
   FQN="(anonymous struct)::operator=", NM="_ZN8CXStringaSEOS_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXString.cpp -nm=_ZN8CXStringaSEOS_")
  //</editor-fold>
  public /*inline*/ CXString /*&*/ $assignMove(CXString /*&&*/$Prm0) {
    this.data = $Prm0.data;
    this.private_flags = $Prm0.private_flags;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "data=" + data // NOI18N
              + ", private_flags=" + private_flags; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang-c/CXString.h", line = 43,
 FQN="(anonymous)", NM="_CXStringSet",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXString.cpp -nm=_CXStringSet")
//</editor-fold>
public class/*struct*/ CXStringSet {
  public type$ptr<CXString> Strings;
  public /*uint*/int Count;
  //<editor-fold defaultstate="collapsed" desc="(anonymous struct)::">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang-c/CXString.h", line = 43,
   FQN="(anonymous struct)::", NM="_ZN11CXStringSetC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXString.cpp -nm=_ZN11CXStringSetC1Ev")
  //</editor-fold>
  public /*inline*/ CXStringSet() {
  }

  
  @Override public String toString() {
    return "" + "Strings=" + Strings // NOI18N
              + ", Count=" + Count; // NOI18N
  }
}

/**
* \brief Retrieve the character data associated with the given string.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCString">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXString.cpp", line = 166,
 FQN="clang_getCString", NM="_Z16clang_getCString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXString.cpp -nm=_Z16clang_getCString")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ clang_getCString( CXString string) {
  return $Impl().clang_getCString(string);
}


/**
* \brief Free the given string.
*/
//<editor-fold defaultstate="collapsed" desc="clang_disposeString">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXString.cpp", line = 173,
 FQN="clang_disposeString", NM="_Z19clang_disposeString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXString.cpp -nm=_Z19clang_disposeString")
//</editor-fold>
public static void clang_disposeString( CXString string) {
  $Impl().clang_disposeString(string);
}


/**
* \brief Free the given string set.
*/
//<editor-fold defaultstate="collapsed" desc="clang_disposeStringSet">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXString.cpp", line = 188,
 FQN="clang_disposeStringSet", NM="_Z22clang_disposeStringSet",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXString.cpp -nm=_Z22clang_disposeStringSet")
//</editor-fold>
public static void clang_disposeStringSet( CXStringSet /*P*/ set) {
  $Impl().clang_disposeStringSet(set);
}

} // END OF class CXStringGlobals
