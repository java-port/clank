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
package org.clang.codegen.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;


//<editor-fold defaultstate="collapsed" desc="static type CGLoopInfoStatics">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp -nm=_ZL14createMetadataRN4llvm11LLVMContextERKN5clang7CodeGen14LoopAttributesENS_8DebugLocE; -static-type=CGLoopInfoStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CGLoopInfoStatics {

//<editor-fold defaultstate="collapsed" desc="createMetadata">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp", line = 22,
 FQN="createMetadata", NM="_ZL14createMetadataRN4llvm11LLVMContextERKN5clang7CodeGen14LoopAttributesENS_8DebugLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp -nm=_ZL14createMetadataRN4llvm11LLVMContextERKN5clang7CodeGen14LoopAttributesENS_8DebugLocE")
//</editor-fold>
public static MDNode /*P*/ createMetadata(final LLVMContext /*&*/ Ctx, final /*const*/ LoopAttributes /*&*/ Attrs, 
              DebugLoc Location) {
  std.unique_ptr<MDTuple> TempNode = null;
  try {
    if (!Attrs.IsParallel && Attrs.VectorizeWidth == 0
       && Attrs.InterleaveCount == 0 && Attrs.UnrollCount == 0
       && Attrs.VectorizeEnable == LoopAttributes.LVEnableState.Unspecified
       && Attrs.UnrollEnable == LoopAttributes.LVEnableState.Unspecified
       && Attrs.DistributeEnable == LoopAttributes.LVEnableState.Unspecified
       && !Location.$bool()) {
      return null;
    }
    
    SmallVector<Metadata /*P*/ > Args/*J*/= new SmallVector<Metadata /*P*/ >(4, (Metadata /*P*/ )null);
    // Reserve operand 0 for loop id self reference.
    TempNode = MDNode.getTemporary(Ctx, new ArrayRef<Metadata /*P*/ >(None, true));
    Args.push_back(TempNode.get());
    
    // If we have a valid debug location for the loop, add it.
    if (Location.$bool()) {
      Args.push_back(Location.getAsMDNode());
    }
    
    // Setting vectorize.width
    if ($greater_uint(Attrs.VectorizeWidth, 0)) {
      Metadata /*P*/ Vals[/*2*/] = new Metadata /*P*/  [/*2*/] {
        MDString.get(Ctx, $("llvm.loop.vectorize.width")), 
        ConstantAsMetadata.get(ConstantInt.get(org.llvm.ir.Type.getInt32Ty(Ctx), $uint2ulong(Attrs.VectorizeWidth)))
      };
      Args.push_back(MDNode.get(Ctx, new ArrayRef<Metadata /*P*/ >(Vals, true)));
    }
    
    // Setting interleave.count
    if ($greater_uint(Attrs.InterleaveCount, 0)) {
      Metadata /*P*/ Vals[/*2*/] = new Metadata /*P*/  [/*2*/] {
        MDString.get(Ctx, $("llvm.loop.interleave.count")), 
        ConstantAsMetadata.get(ConstantInt.get(org.llvm.ir.Type.getInt32Ty(Ctx), $uint2ulong(Attrs.InterleaveCount)))
      };
      Args.push_back(MDNode.get(Ctx, new ArrayRef<Metadata /*P*/ >(Vals, true)));
    }
    
    // Setting interleave.count
    if ($greater_uint(Attrs.UnrollCount, 0)) {
      Metadata /*P*/ Vals[/*2*/] = new Metadata /*P*/  [/*2*/] {
        MDString.get(Ctx, $("llvm.loop.unroll.count")), 
        ConstantAsMetadata.get(ConstantInt.get(org.llvm.ir.Type.getInt32Ty(Ctx), $uint2ulong(Attrs.UnrollCount)))
      };
      Args.push_back(MDNode.get(Ctx, new ArrayRef<Metadata /*P*/ >(Vals, true)));
    }
    
    // Setting vectorize.enable
    if (Attrs.VectorizeEnable != LoopAttributes.LVEnableState.Unspecified) {
      Metadata /*P*/ Vals[/*2*/] = new Metadata /*P*/  [/*2*/] {
        MDString.get(Ctx, $("llvm.loop.vectorize.enable")), 
        ConstantAsMetadata.get(ConstantInt.get(org.llvm.ir.Type.getInt1Ty(Ctx), ((Attrs.VectorizeEnable
                   == LoopAttributes.LVEnableState.Enable) ? 1 : 0)))
      };
      Args.push_back(MDNode.get(Ctx, new ArrayRef<Metadata /*P*/ >(Vals, true)));
    }
    
    // Setting unroll.full or unroll.disable
    if (Attrs.UnrollEnable != LoopAttributes.LVEnableState.Unspecified) {
      std.string Name/*J*/= new std.string();
      if (Attrs.UnrollEnable == LoopAttributes.LVEnableState.Enable) {
        Name.$assign_T$C$P(/*KEEP_STR*/"llvm.loop.unroll.enable");
      } else if (Attrs.UnrollEnable == LoopAttributes.LVEnableState.Full) {
        Name.$assign_T$C$P(/*KEEP_STR*/"llvm.loop.unroll.full");
      } else {
        Name.$assign_T$C$P(/*KEEP_STR*/"llvm.loop.unroll.disable");
      }
      Metadata /*P*/ Vals[/*1*/] = new Metadata /*P*/  [/*1*/] {MDString.get(Ctx, new StringRef(Name))};
      Args.push_back(MDNode.get(Ctx, new ArrayRef<Metadata /*P*/ >(Vals, true)));
    }
    if (Attrs.DistributeEnable != LoopAttributes.LVEnableState.Unspecified) {
      Metadata /*P*/ Vals[/*2*/] = new Metadata /*P*/  [/*2*/] {
        MDString.get(Ctx, $("llvm.loop.distribute.enable")), 
        ConstantAsMetadata.get(ConstantInt.get(org.llvm.ir.Type.getInt1Ty(Ctx), ((Attrs.DistributeEnable
                   == LoopAttributes.LVEnableState.Enable) ? 1 : 0)))
      };
      Args.push_back(MDNode.get(Ctx, new ArrayRef<Metadata /*P*/ >(Vals, true)));
    }
    
    // Set the first operand to itself.
    MDNode /*P*/ LoopID = MDNode.get(Ctx, new ArrayRef<Metadata /*P*/ >(Args, true));
    LoopID.replaceOperandWith(0, LoopID);
    return LoopID;
  } finally {
    if (TempNode != null) { TempNode.$destroy(); }
  }
}

} // END OF class CGLoopInfoStatics
