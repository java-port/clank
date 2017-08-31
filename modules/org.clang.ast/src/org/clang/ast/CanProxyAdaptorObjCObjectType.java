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

//<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::ObjCObjectType>">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 559,
 FQN="clang::CanProxyAdaptor<clang::ObjCObjectType>", NM="_ZN5clang15CanProxyAdaptorINS_14ObjCObjectTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang15CanProxyAdaptorINS_14ObjCObjectTypeEEE")
//</editor-fold>
public class/*struct*/ CanProxyAdaptorObjCObjectType extends /*public*/ CanProxyBase<ObjCObjectType> implements CanProxyAdaptor<ObjCObjectType> {
  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::ObjCObjectType>::getBaseType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 562,
   FQN="clang::CanProxyAdaptor<clang::ObjCObjectType>::getBaseType", NM="_ZNK5clang15CanProxyAdaptorINS_14ObjCObjectTypeEE11getBaseTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_14ObjCObjectTypeEE11getBaseTypeEv")
  //</editor-fold>
  public CanQual<Type> getBaseType() /*const*/ {
    return CanQual.<Type>CreateUnsafe(this.getTypePtr().getBaseType());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::ObjCObjectType>::getInterface">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 563,
   FQN="clang::CanProxyAdaptor<clang::ObjCObjectType>::getInterface", NM="_ZNK5clang15CanProxyAdaptorINS_14ObjCObjectTypeEE12getInterfaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_14ObjCObjectTypeEE12getInterfaceEv")
  //</editor-fold>
  public /*const*/ ObjCInterfaceDecl /*P*/ getInterface() /*const*/ {
    return this.getTypePtr().getInterface();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::ObjCObjectType>::isObjCUnqualifiedId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 565,
   FQN="clang::CanProxyAdaptor<clang::ObjCObjectType>::isObjCUnqualifiedId", NM="_ZNK5clang15CanProxyAdaptorINS_14ObjCObjectTypeEE19isObjCUnqualifiedIdEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_14ObjCObjectTypeEE19isObjCUnqualifiedIdEv")
  //</editor-fold>
  public boolean isObjCUnqualifiedId() /*const*/ {
    return this.getTypePtr().isObjCUnqualifiedId();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::ObjCObjectType>::isObjCUnqualifiedClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 566,
   FQN="clang::CanProxyAdaptor<clang::ObjCObjectType>::isObjCUnqualifiedClass", NM="_ZNK5clang15CanProxyAdaptorINS_14ObjCObjectTypeEE22isObjCUnqualifiedClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_14ObjCObjectTypeEE22isObjCUnqualifiedClassEv")
  //</editor-fold>
  public boolean isObjCUnqualifiedClass() /*const*/ {
    return this.getTypePtr().isObjCUnqualifiedClass();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::ObjCObjectType>::isObjCQualifiedId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 567,
   FQN="clang::CanProxyAdaptor<clang::ObjCObjectType>::isObjCQualifiedId", NM="_ZNK5clang15CanProxyAdaptorINS_14ObjCObjectTypeEE17isObjCQualifiedIdEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_14ObjCObjectTypeEE17isObjCQualifiedIdEv")
  //</editor-fold>
  public boolean isObjCQualifiedId() /*const*/ {
    return this.getTypePtr().isObjCQualifiedId();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::ObjCObjectType>::isObjCQualifiedClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 568,
   FQN="clang::CanProxyAdaptor<clang::ObjCObjectType>::isObjCQualifiedClass", NM="_ZNK5clang15CanProxyAdaptorINS_14ObjCObjectTypeEE20isObjCQualifiedClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_14ObjCObjectTypeEE20isObjCQualifiedClassEv")
  //</editor-fold>
  public boolean isObjCQualifiedClass() /*const*/ {
    return this.getTypePtr().isObjCQualifiedClass();
  }

  
  /*typedef ObjCObjectPointerType::qual_iterator qual_iterator*/
//  public final class qual_iterator extends type$ptr<ObjCProtocolDecl/*P*/>/*qual_iterator*/{ };
  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::ObjCObjectType>::qual_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 571,
   FQN="clang::CanProxyAdaptor<clang::ObjCObjectType>::qual_begin", NM="_ZNK5clang15CanProxyAdaptorINS_14ObjCObjectTypeEE10qual_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_14ObjCObjectTypeEE10qual_beginEv")
  //</editor-fold>
  public type$ptr<ObjCProtocolDecl/*P*/>/*qual_iterator*/ qual_begin() /*const*/ {
    return this.getTypePtr().qual_begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::ObjCObjectType>::qual_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 572,
   FQN="clang::CanProxyAdaptor<clang::ObjCObjectType>::qual_end", NM="_ZNK5clang15CanProxyAdaptorINS_14ObjCObjectTypeEE8qual_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_14ObjCObjectTypeEE8qual_endEv")
  //</editor-fold>
  public type$ptr<ObjCProtocolDecl/*P*/>/*qual_iterator*/ qual_end() /*const*/ {
    return this.getTypePtr().qual_end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::ObjCObjectType>::qual_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 573,
   FQN="clang::CanProxyAdaptor<clang::ObjCObjectType>::qual_empty", NM="_ZNK5clang15CanProxyAdaptorINS_14ObjCObjectTypeEE10qual_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_14ObjCObjectTypeEE10qual_emptyEv")
  //</editor-fold>
  public boolean qual_empty() /*const*/ {
    return this.getTypePtr().qual_empty();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::ObjCObjectType>::getNumProtocols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 574,
   FQN="clang::CanProxyAdaptor<clang::ObjCObjectType>::getNumProtocols", NM="_ZNK5clang15CanProxyAdaptorINS_14ObjCObjectTypeEE15getNumProtocolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_14ObjCObjectTypeEE15getNumProtocolsEv")
  //</editor-fold>
  public /*uint*/int getNumProtocols() /*const*/ {
    return this.getTypePtr().getNumProtocols();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
