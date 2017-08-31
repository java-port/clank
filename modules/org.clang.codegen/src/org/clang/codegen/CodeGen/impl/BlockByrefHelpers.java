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

package org.clang.codegen.CodeGen.impl;

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.llvm.ir.*;


/// A pair of helper functions for a __block variable.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockByrefHelpers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 215,
 FQN="clang::CodeGen::BlockByrefHelpers", NM="_ZN5clang7CodeGen17BlockByrefHelpersE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen17BlockByrefHelpersE")
//</editor-fold>
public abstract class BlockByrefHelpers extends FoldingSetImpl.NodeImpl implements /*public*/ FoldingSetImpl.Node, Destructors.ClassWithDestructor {
// MSVC requires this type to be complete in order to process this
  // header.
  /*public:*/
  public Constant /*P*/ CopyHelper;
  public Constant /*P*/ DisposeHelper;
  
  /// The alignment of the field.  This is important because
  /// different offsets to the field within the byref struct need to
  /// have different helper functions.
  public CharUnits Alignment;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockByrefHelpers::BlockByrefHelpers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 227,
   FQN="clang::CodeGen::BlockByrefHelpers::BlockByrefHelpers", NM="_ZN5clang7CodeGen17BlockByrefHelpersC1ENS_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen17BlockByrefHelpersC1ENS_9CharUnitsE")
  //</editor-fold>
  public BlockByrefHelpers(CharUnits alignment) {
    // : FoldingSetNode(), Alignment(alignment) 
    //START JInit
    $Node();
    this.Alignment = new CharUnits(alignment);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockByrefHelpers::BlockByrefHelpers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 228,
   FQN="clang::CodeGen::BlockByrefHelpers::BlockByrefHelpers", NM="_ZN5clang7CodeGen17BlockByrefHelpersC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen17BlockByrefHelpersC1ERKS1_")
  //</editor-fold>
  public BlockByrefHelpers(final /*const*/ BlockByrefHelpers /*&*/ $Prm0) {
    // : FoldingSetNode(), CopyHelper(.CopyHelper), DisposeHelper(.DisposeHelper), Alignment(.Alignment)/* = default*/ 
    //START JInit
    $Node($Prm0);
    this.CopyHelper = $Prm0.CopyHelper;
    this.DisposeHelper = $Prm0.DisposeHelper;
    this.Alignment = new CharUnits($Prm0.Alignment);
    //END JInit
  }

  
  // Anchor the vtable to this translation unit.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockByrefHelpers::~BlockByrefHelpers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 43,
   FQN="clang::CodeGen::BlockByrefHelpers::~BlockByrefHelpers", NM="_ZN5clang7CodeGen17BlockByrefHelpersD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen17BlockByrefHelpersD0Ev")
  //</editor-fold>
  public void $destroy() {
    FoldingSetImpl.Node.super.$destroy$Node();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockByrefHelpers::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 231,
   FQN="clang::CodeGen::BlockByrefHelpers::Profile", NM="_ZNK5clang7CodeGen17BlockByrefHelpers7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZNK5clang7CodeGen17BlockByrefHelpers7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ id) /*const*/ {
    id.AddInteger_llong(Alignment.getQuantity());
    profileImpl(id);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockByrefHelpers::profileImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 235,
   FQN="clang::CodeGen::BlockByrefHelpers::profileImpl", NM="_ZNK5clang7CodeGen17BlockByrefHelpers11profileImplERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZNK5clang7CodeGen17BlockByrefHelpers11profileImplERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public abstract /*virtual*/ void profileImpl(final FoldingSetNodeID /*&*/ id) /*const*//* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockByrefHelpers::needsCopy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 237,
   FQN="clang::CodeGen::BlockByrefHelpers::needsCopy", NM="_ZNK5clang7CodeGen17BlockByrefHelpers9needsCopyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZNK5clang7CodeGen17BlockByrefHelpers9needsCopyEv")
  //</editor-fold>
  public /*virtual*/ boolean needsCopy() /*const*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockByrefHelpers::emitCopy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 238,
   FQN="clang::CodeGen::BlockByrefHelpers::emitCopy", NM="_ZN5clang7CodeGen17BlockByrefHelpers8emitCopyERNS0_15CodeGenFunctionENS0_7AddressES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen17BlockByrefHelpers8emitCopyERNS0_15CodeGenFunctionENS0_7AddressES4_")
  //</editor-fold>
  public abstract /*virtual*/ void emitCopy(final CodeGenFunction /*&*/ CGF, Address dest, Address src)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockByrefHelpers::needsDispose">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 240,
   FQN="clang::CodeGen::BlockByrefHelpers::needsDispose", NM="_ZNK5clang7CodeGen17BlockByrefHelpers12needsDisposeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZNK5clang7CodeGen17BlockByrefHelpers12needsDisposeEv")
  //</editor-fold>
  public /*virtual*/ boolean needsDispose() /*const*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockByrefHelpers::emitDispose">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 241,
   FQN="clang::CodeGen::BlockByrefHelpers::emitDispose", NM="_ZN5clang7CodeGen17BlockByrefHelpers11emitDisposeERNS0_15CodeGenFunctionENS0_7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen17BlockByrefHelpers11emitDisposeERNS0_15CodeGenFunctionENS0_7AddressE")
  //</editor-fold>
  public abstract /*virtual*/ void emitDispose(final CodeGenFunction /*&*/ CGF, Address field)/* = 0*/;

  
  @Override public String toString() {
    return "" + "CopyHelper=" + CopyHelper // NOI18N
              + ", DisposeHelper=" + DisposeHelper // NOI18N
              + ", Alignment=" + Alignment // NOI18N
              + super.toString(); // NOI18N
  }
}
