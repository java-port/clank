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

package org.llvm.adt;

import org.clank.support.*;
import org.llvm.adt.*;


//===----------------------------------------------------------------------===//
/// FoldingSetNodeWrapper - This template class is used to "wrap" arbitrary
/// types in an enclosing object so that they can be inserted into FoldingSets.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeWrapper">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 712,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 698,
 FQN="llvm::FoldingSetNodeWrapper", NM="_ZN4llvm21FoldingSetNodeWrapperE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm21FoldingSetNodeWrapperE")
//</editor-fold>
public class FoldingSetNodeWrapper</*typename*/ T extends NativeFoldingSetTrait.NativeProfilable>  extends FoldingSetImpl.NodeImpl implements /*public*/ FoldingSetImpl.Node {
  private T data;
/*public:*/
  /*template <typename ... Ts> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeWrapper::FoldingSetNodeWrapper<T>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 718,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 703,
   FQN="llvm::FoldingSetNodeWrapper::FoldingSetNodeWrapper<T>", NM="Tpl__ZN4llvm21FoldingSetNodeWrapperC1EDpOT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=Tpl__ZN4llvm21FoldingSetNodeWrapperC1EDpOT_")
  //</editor-fold>
  public /*explicit*/ </*typename*/ /*...*/ Ts> FoldingSetNodeWrapper(Ts... /*&&*/Args) {
    // : data(std::forward<Ts>(Args)...) 
    assert Args != null;
    if (Args.length == 1) {
      data = (T)Args[0];
      return;
    }
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeWrapper::Profile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 721,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 707,
   FQN="llvm::FoldingSetNodeWrapper::Profile", NM="_ZN4llvm21FoldingSetNodeWrapper7ProfileERNS_16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm21FoldingSetNodeWrapper7ProfileERNS_16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) {
    data.Profile(ID);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeWrapper::getValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 723,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 709,
   FQN="llvm::FoldingSetNodeWrapper::getValue", NM="_ZN4llvm21FoldingSetNodeWrapper8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm21FoldingSetNodeWrapper8getValueEv")
  //</editor-fold>
  public T /*&*/ getValue() {
    return data;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeWrapper::getValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 724,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 710,
   FQN="llvm::FoldingSetNodeWrapper::getValue", NM="_ZNK4llvm21FoldingSetNodeWrapper8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm21FoldingSetNodeWrapper8getValueEv")
  //</editor-fold>
  public /*const*/ T /*&*/ getValue$Const() /*const*/ {
    return data;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeWrapper::operator type-parameter-0-0 & ">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 726,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 712,
   FQN="llvm::FoldingSetNodeWrapper::operator type-parameter-0-0 & ", NM="_ZN4llvm21FoldingSetNodeWrappercvRT_Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm21FoldingSetNodeWrappercvRT_Ev")
  //</editor-fold>
  public T /*&*/ $T$R() {
    return data;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeWrapper::operator const type-parameter-0-0 & ">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 727,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 713,
   FQN="llvm::FoldingSetNodeWrapper::operator const type-parameter-0-0 & ", NM="_ZNK4llvm21FoldingSetNodeWrappercvRKT_Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm21FoldingSetNodeWrappercvRKT_Ev")
  //</editor-fold>
  public /*const*/ T /*&*/ $T$C$R() /*const*/ {
    return data;
  }

  
  @Override public String toString() {
    return "" + "data=" + data // NOI18N
              + super.toString(); // NOI18N
  }
}
