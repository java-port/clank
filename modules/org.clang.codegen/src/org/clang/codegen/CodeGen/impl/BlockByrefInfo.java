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
import org.clank.support.JavaDifferentiators.*;
import org.clang.ast.*;
import org.clank.support.Native.NativePOD;
import org.llvm.ir.*;


/// Information about the layout of a __block variable.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockByrefInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 144,
 FQN="clang::CodeGen::BlockByrefInfo", NM="_ZN5clang7CodeGen14BlockByrefInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen14BlockByrefInfoE")
//</editor-fold>
public class BlockByrefInfo implements NativePOD<BlockByrefInfo>, NativeMoveable<BlockByrefInfo> {
/*public:*/
  public StructType /*P*/ Type;
  public /*uint*/int FieldIndex;
  public CharUnits ByrefAlignment;
  public CharUnits FieldOffset;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockByrefInfo::BlockByrefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 144,
   FQN="clang::CodeGen::BlockByrefInfo::BlockByrefInfo", NM="_ZN5clang7CodeGen14BlockByrefInfoC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen14BlockByrefInfoC1ERKS1_")
  //</editor-fold>
  public /*inline*/ BlockByrefInfo(final /*const*/ BlockByrefInfo /*&*/ $Prm0) {
    // : Type(.Type), FieldIndex(.FieldIndex), ByrefAlignment(.ByrefAlignment), FieldOffset(.FieldOffset) 
    //START JInit
    this.Type = $Prm0.Type;
    this.FieldIndex = $Prm0.FieldIndex;
    this.ByrefAlignment = new CharUnits($Prm0.ByrefAlignment);
    this.FieldOffset = new CharUnits($Prm0.FieldOffset);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockByrefInfo::BlockByrefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 144,
   FQN="clang::CodeGen::BlockByrefInfo::BlockByrefInfo", NM="_ZN5clang7CodeGen14BlockByrefInfoC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen14BlockByrefInfoC1EOS1_")
  //</editor-fold>
  public /*inline*/ BlockByrefInfo(JD$Move _dparam, final BlockByrefInfo /*&&*/$Prm0) {
    // : Type(static_cast<BlockByrefInfo &&>().Type), FieldIndex(static_cast<BlockByrefInfo &&>().FieldIndex), ByrefAlignment(static_cast<BlockByrefInfo &&>().ByrefAlignment), FieldOffset(static_cast<BlockByrefInfo &&>().FieldOffset) 
    //START JInit
    this.Type = $Prm0.Type;
    this.FieldIndex = $Prm0.FieldIndex;
    this.ByrefAlignment = new CharUnits(JD$Move.INSTANCE, $Prm0.ByrefAlignment);
    this.FieldOffset = new CharUnits(JD$Move.INSTANCE, $Prm0.FieldOffset);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::BlockByrefInfo::BlockByrefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 144,
   FQN="clang::CodeGen::BlockByrefInfo::BlockByrefInfo", NM="_ZN5clang7CodeGen14BlockByrefInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen14BlockByrefInfoC1Ev")
  //</editor-fold>
  public /*inline*/ BlockByrefInfo() {
    // : ByrefAlignment(), FieldOffset() 
    //START JInit
    this.ByrefAlignment = new CharUnits();
    this.FieldOffset = new CharUnits();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override public BlockByrefInfo clone() {
    return new BlockByrefInfo(this);
  }
  
  @Override public BlockByrefInfo move() {
    return new BlockByrefInfo(JD$Move.INSTANCE, this);
  }
  
  @Override 
  public BlockByrefInfo $assign(BlockByrefInfo $Prm0) { 
    this.Type = $Prm0.Type; 
    this.FieldIndex = $Prm0.FieldIndex; 
    this.ByrefAlignment.$assign($Prm0.ByrefAlignment); 
    this.FieldOffset.$assign($Prm0.FieldOffset); 
    return this; 
  } 
  
  @Override 
  public BlockByrefInfo $assignMove(BlockByrefInfo $Prm0) { 
    this.Type = $Prm0.Type; 
    this.FieldIndex = $Prm0.FieldIndex; 
    this.ByrefAlignment.$assignMove($Prm0.ByrefAlignment); 
    this.FieldOffset.$assignMove($Prm0.FieldOffset); 
    return this; 
  } 
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Type=" + Type // NOI18N
              + ", FieldIndex=" + FieldIndex // NOI18N
              + ", ByrefAlignment=" + ByrefAlignment // NOI18N
              + ", FieldOffset=" + FieldOffset; // NOI18N
  }
}
