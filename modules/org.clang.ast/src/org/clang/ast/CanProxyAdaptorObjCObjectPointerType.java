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

package org.clang.ast;

import org.clank.support.*;
import org.clank.support.aliases.*;

//<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::ObjCObjectPointerType>">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 577,
 FQN="clang::CanProxyAdaptor<clang::ObjCObjectPointerType>", NM="_ZN5clang15CanProxyAdaptorINS_21ObjCObjectPointerTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang15CanProxyAdaptorINS_21ObjCObjectPointerTypeEEE")
//</editor-fold>
public class/*struct*/ CanProxyAdaptorObjCObjectPointerType extends /*public*/ CanProxyBase<ObjCObjectPointerType> implements CanProxyAdaptor<ObjCObjectPointerType> {
  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::ObjCObjectPointerType>::getPointeeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 580,
   FQN="clang::CanProxyAdaptor<clang::ObjCObjectPointerType>::getPointeeType", NM="_ZNK5clang15CanProxyAdaptorINS_21ObjCObjectPointerTypeEE14getPointeeTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_21ObjCObjectPointerTypeEE14getPointeeTypeEv")
  //</editor-fold>
  public CanQual<Type> getPointeeType() /*const*/ {
    return CanQual.<Type>CreateUnsafe(this.getTypePtr().getPointeeType());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::ObjCObjectPointerType>::getInterfaceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 581,
   FQN="clang::CanProxyAdaptor<clang::ObjCObjectPointerType>::getInterfaceType", NM="_ZNK5clang15CanProxyAdaptorINS_21ObjCObjectPointerTypeEE16getInterfaceTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_21ObjCObjectPointerTypeEE16getInterfaceTypeEv")
  //</editor-fold>
  public /*const*/ ObjCInterfaceType /*P*/ getInterfaceType() /*const*/ {
    return this.getTypePtr().getInterfaceType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::ObjCObjectPointerType>::isObjCIdType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 583,
   FQN="clang::CanProxyAdaptor<clang::ObjCObjectPointerType>::isObjCIdType", NM="_ZNK5clang15CanProxyAdaptorINS_21ObjCObjectPointerTypeEE12isObjCIdTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_21ObjCObjectPointerTypeEE12isObjCIdTypeEv")
  //</editor-fold>
  public boolean isObjCIdType() /*const*/ {
    return this.getTypePtr().isObjCIdType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::ObjCObjectPointerType>::isObjCClassType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 584,
   FQN="clang::CanProxyAdaptor<clang::ObjCObjectPointerType>::isObjCClassType", NM="_ZNK5clang15CanProxyAdaptorINS_21ObjCObjectPointerTypeEE15isObjCClassTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_21ObjCObjectPointerTypeEE15isObjCClassTypeEv")
  //</editor-fold>
  public boolean isObjCClassType() /*const*/ {
    return this.getTypePtr().isObjCClassType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::ObjCObjectPointerType>::isObjCQualifiedIdType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 585,
   FQN="clang::CanProxyAdaptor<clang::ObjCObjectPointerType>::isObjCQualifiedIdType", NM="_ZNK5clang15CanProxyAdaptorINS_21ObjCObjectPointerTypeEE21isObjCQualifiedIdTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_21ObjCObjectPointerTypeEE21isObjCQualifiedIdTypeEv")
  //</editor-fold>
  public boolean isObjCQualifiedIdType() /*const*/ {
    return this.getTypePtr().isObjCQualifiedIdType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::ObjCObjectPointerType>::isObjCQualifiedClassType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 586,
   FQN="clang::CanProxyAdaptor<clang::ObjCObjectPointerType>::isObjCQualifiedClassType", NM="_ZNK5clang15CanProxyAdaptorINS_21ObjCObjectPointerTypeEE24isObjCQualifiedClassTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_21ObjCObjectPointerTypeEE24isObjCQualifiedClassTypeEv")
  //</editor-fold>
  public boolean isObjCQualifiedClassType() /*const*/ {
    return this.getTypePtr().isObjCQualifiedClassType();
  }

  
  /*typedef ObjCObjectPointerType::qual_iterator qual_iterator*/
//  public final class qual_iterator extends type$ptr<ObjCProtocolDecl/*P*/>/*qual_iterator*/{ };
  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::ObjCObjectPointerType>::qual_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 589,
   FQN="clang::CanProxyAdaptor<clang::ObjCObjectPointerType>::qual_begin", NM="_ZNK5clang15CanProxyAdaptorINS_21ObjCObjectPointerTypeEE10qual_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_21ObjCObjectPointerTypeEE10qual_beginEv")
  //</editor-fold>
  public type$ptr<ObjCProtocolDecl/*P*/>/*qual_iterator*/ qual_begin() /*const*/ {
    return this.getTypePtr().qual_begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::ObjCObjectPointerType>::qual_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 590,
   FQN="clang::CanProxyAdaptor<clang::ObjCObjectPointerType>::qual_end", NM="_ZNK5clang15CanProxyAdaptorINS_21ObjCObjectPointerTypeEE8qual_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_21ObjCObjectPointerTypeEE8qual_endEv")
  //</editor-fold>
  public type$ptr<ObjCProtocolDecl/*P*/>/*qual_iterator*/ qual_end() /*const*/ {
    return this.getTypePtr().qual_end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::ObjCObjectPointerType>::qual_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 591,
   FQN="clang::CanProxyAdaptor<clang::ObjCObjectPointerType>::qual_empty", NM="_ZNK5clang15CanProxyAdaptorINS_21ObjCObjectPointerTypeEE10qual_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_21ObjCObjectPointerTypeEE10qual_emptyEv")
  //</editor-fold>
  public boolean qual_empty() /*const*/ {
    return this.getTypePtr().qual_empty();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::ObjCObjectPointerType>::getNumProtocols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 592,
   FQN="clang::CanProxyAdaptor<clang::ObjCObjectPointerType>::getNumProtocols", NM="_ZNK5clang15CanProxyAdaptorINS_21ObjCObjectPointerTypeEE15getNumProtocolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_21ObjCObjectPointerTypeEE15getNumProtocolsEv")
  //</editor-fold>
  public /*uint*/int getNumProtocols() /*const*/ {
    return this.getTypePtr().getNumProtocols();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
