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

package org.llvm.ir.impl;

import org.clank.support.*;
import org.llvm.ir.*;

//<editor-fold defaultstate="collapsed" desc="llvm::IntAttributeImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 115,
 FQN="llvm::IntAttributeImpl", NM="_ZN4llvm16IntAttributeImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm16IntAttributeImplE")
//</editor-fold>
public class IntAttributeImpl extends /*public*/ EnumAttributeImpl implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::IntAttributeImpl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 408,
   FQN="llvm::IntAttributeImpl::anchor", NM="_ZN4llvm16IntAttributeImpl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm16IntAttributeImpl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  private long/*uint64_t*/ Val;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::IntAttributeImpl::IntAttributeImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 120,
   FQN="llvm::IntAttributeImpl::IntAttributeImpl", NM="_ZN4llvm16IntAttributeImplC1ENS_9Attribute8AttrKindEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm16IntAttributeImplC1ENS_9Attribute8AttrKindEy")
  //</editor-fold>
  public IntAttributeImpl(Attribute.AttrKind Kind, long/*uint64_t*/ Val) {
    // : EnumAttributeImpl(IntAttrEntry, Kind), Val(Val) 
    //START JInit
    super(AttrEntryKind.IntAttrEntry, Kind);
    this.Val = Val;
    //END JInit
    assert ((Kind == Attribute.AttrKind.Alignment || Kind == Attribute.AttrKind.StackAlignment || Kind == Attribute.AttrKind.Dereferenceable || Kind == Attribute.AttrKind.DereferenceableOrNull || Kind == Attribute.AttrKind.AllocSize)) : "Wrong kind for int attribute!";
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IntAttributeImpl::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 129,
   FQN="llvm::IntAttributeImpl::getValue", NM="_ZNK4llvm16IntAttributeImpl8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm16IntAttributeImpl8getValueEv")
  //</editor-fold>
  public long/*uint64_t*/ getValue() /*const*/ {
    return Val;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IntAttributeImpl::~IntAttributeImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 115,
   FQN="llvm::IntAttributeImpl::~IntAttributeImpl", NM="_ZN4llvm16IntAttributeImplD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm16IntAttributeImplD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Val=" + Val // NOI18N
              + super.toString(); // NOI18N
  }
}
