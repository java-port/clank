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

package org.llvm.ir;

import org.clank.support.*;


/// \brief SFINAE metafunction for computing whether \c ResultT provides an
/// \c invalidate member function.
/*template <typename IRUnitT, typename ResultT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::detail::ResultHasInvalidateMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 100,
 FQN="llvm::detail::ResultHasInvalidateMethod", NM="_ZN4llvm6detail25ResultHasInvalidateMethodE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail25ResultHasInvalidateMethodE")
//</editor-fold>
public class ResultHasInvalidateMethod</*typename*/ IRUnitT, /*typename*/ ResultT>  {
  // JAVA: typedef char SmallType;
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::ResultHasInvalidateMethod::BigType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 102,
   FQN="llvm::detail::ResultHasInvalidateMethod::BigType", NM="_ZN4llvm6detail25ResultHasInvalidateMethod7BigTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail25ResultHasInvalidateMethod7BigTypeE")
  //</editor-fold>
  private static class/*struct*/ BigType {
    public /*char*/byte a;
    public /*char*/byte b;
    
    @Override public String toString() {
      return "" + "a=" + a // NOI18N
                + ", b=" + b; // NOI18N
    }
  };
  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::ResultHasInvalidateMethod::f">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 109,
   FQN="llvm::detail::ResultHasInvalidateMethod::f", NM="Tpl__ZN4llvm6detail25ResultHasInvalidateMethod1fEPNS1_7CheckerIT_XadsrS3_10invalidateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=Tpl__ZN4llvm6detail25ResultHasInvalidateMethod1fEPNS1_7CheckerIT_XadsrS3_10invalidateEEE")
  //</editor-fold>
  private static </*typename*/ T> /*char*/byte f(Checker<T>/*<$AddrOf(T.invalidate)>*/ /*P*/ $Prm0) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }

  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::ResultHasInvalidateMethod::f">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 110,
   FQN="llvm::detail::ResultHasInvalidateMethod::f", NM="Tpl__ZN4llvm6detail25ResultHasInvalidateMethod1fEz",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=Tpl__ZN4llvm6detail25ResultHasInvalidateMethod1fEz")
  //</editor-fold>
  private static </*typename*/ T> BigType f(Object ... $VarArg) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::ResultHasInvalidateMethod::(anonymous)">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 113,
   FQN="llvm::detail::ResultHasInvalidateMethod::(anonymous)", NM="_ZN4llvm6detail25ResultHasInvalidateMethodE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail25ResultHasInvalidateMethodE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*<dependent type>*/boolean Value = false;//sizeof(f<ResultT>(null)) == $sizeof_Char();
  /*}*/;
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public interface Checker<T> {
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
