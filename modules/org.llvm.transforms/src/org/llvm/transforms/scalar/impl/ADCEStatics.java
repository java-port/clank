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
package org.llvm.transforms.scalar.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.SmallPtrSet;
import org.llvm.adt.SmallPtrSetImpl;
import org.llvm.adt.Statistic;
import org.llvm.adt.aliases.DenseMapInfo$LikePtr;
import org.llvm.adt.aliases.SmallVector;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.pass.*;
import static org.llvm.pass.IrLlvmGlobals.$out_raw_ostream_Value$C;
import static org.llvm.pass.IrLlvmGlobals.instructions_Function;


//<editor-fold defaultstate="collapsed" desc="static type ADCEStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.transforms.scalar.impl.ADCEStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZL10NumRemoved;_ZL13aggressiveDCERN4llvm8FunctionE;_ZL17collectLiveScopesRKN4llvm10DILocationERNS_15SmallPtrSetImplIPKNS_8MetadataEEE;_ZL17collectLiveScopesRKN4llvm12DILocalScopeERNS_15SmallPtrSetImplIPKNS_8MetadataEEE;_ZL21isInstrumentsConstantRN4llvm11InstructionE;_ZL32InitializeADCELegacyPassPassFlag;_ZL32initializeADCELegacyPassPassOnceRN4llvm12PassRegistryE; -static-type=ADCEStatics -package=org.llvm.transforms.scalar.impl")
//</editor-fold>
public final class ADCEStatics {

//<editor-fold defaultstate="collapsed" desc="NumRemoved">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp", line = 36,
 FQN="NumRemoved", NM="_ZL10NumRemoved",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZL10NumRemoved")
//</editor-fold>
public static Statistic NumRemoved = new Statistic($("adce"), $("NumRemoved"), $("Number of instructions removed"), 0, false);
//<editor-fold defaultstate="collapsed" desc="collectLiveScopes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp", line = 38,
 FQN="collectLiveScopes", NM="_ZL17collectLiveScopesRKN4llvm12DILocalScopeERNS_15SmallPtrSetImplIPKNS_8MetadataEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZL17collectLiveScopesRKN4llvm12DILocalScopeERNS_15SmallPtrSetImplIPKNS_8MetadataEEE")
//</editor-fold>
public static void collectLiveScopes_DILocalScope$C_SmallPtrSetImpl$Metadata$C$P(final /*const*/ DILocalScope /*&*/ LS, 
                                                             final SmallPtrSetImpl</*const*/ Metadata /*P*/ > /*&*/ AliveScopes) {
  if (!AliveScopes.insert($AddrOf(LS)).second) {
    return;
  }
  if (isa_DISubprogram(LS)) {
    return;
  }
  
  // Tail-recurse through the scope chain.
  collectLiveScopes_DILocalScope$C_SmallPtrSetImpl$Metadata$C$P(cast_DILocalScope($Deref(LS.getScope$Ref().$Metadata$P())), AliveScopes);
}

//<editor-fold defaultstate="collapsed" desc="collectLiveScopes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp", line = 50,
 FQN="collectLiveScopes", NM="_ZL17collectLiveScopesRKN4llvm10DILocationERNS_15SmallPtrSetImplIPKNS_8MetadataEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZL17collectLiveScopesRKN4llvm10DILocationERNS_15SmallPtrSetImplIPKNS_8MetadataEEE")
//</editor-fold>
public static void collectLiveScopes_DILocation$C_SmallPtrSetImpl$Metadata$C$P(final /*const*/ DILocation /*&*/ DL, 
                                                           final SmallPtrSetImpl</*const*/ Metadata /*P*/ > /*&*/ AliveScopes) {
  // Even though DILocations are not scopes, shove them into AliveScopes so we
  // don't revisit them.
  if (!AliveScopes.insert($AddrOf(DL)).second) {
    return;
  }
  
  // Collect live scopes from the scope chain.
  collectLiveScopes_DILocalScope$C_SmallPtrSetImpl$Metadata$C$P($Deref(DL.getScope()), AliveScopes);
  {
    
    // Tail-recurse through the inlined-at chain.
    /*const*/ DILocation /*P*/ IA = DL.getInlinedAt();
    if ((IA != null)) {
      collectLiveScopes_DILocation$C_SmallPtrSetImpl$Metadata$C$P($Deref(IA), AliveScopes);
    }
  }
}


// Check if this instruction is a runtime call for value profiling and
// if it's instrumenting a constant.
//<editor-fold defaultstate="collapsed" desc="isInstrumentsConstant">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp", line = 67,
 FQN="isInstrumentsConstant", NM="_ZL21isInstrumentsConstantRN4llvm11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZL21isInstrumentsConstantRN4llvm11InstructionE")
//</editor-fold>
public static boolean isInstrumentsConstant(final Instruction /*&*/ I) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="aggressiveDCE">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp", line = 76,
 FQN="aggressiveDCE", NM="_ZL13aggressiveDCERN4llvm8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZL13aggressiveDCERN4llvm8FunctionE")
//</editor-fold>
public static boolean aggressiveDCE(final Function /*&*/ F) {
  SmallPtrSet<Instruction /*P*/ > Alive/*J*/= new SmallPtrSet<Instruction /*P*/ >(DenseMapInfo$LikePtr.$Info(), 32);
  SmallVector<Instruction /*P*/ > Worklist/*J*/= new SmallVector<Instruction /*P*/ >(128, (Instruction /*P*/ )null);
  
  // Collect the set of "root" instructions that are known live.
  for (final Instruction /*&*/ I : instructions_Function(F)) {
    if (isa_TerminatorInst(I) || I.isEHPad() || I.mayHaveSideEffects()) {
      // Skip any value profile instrumentation calls if they are
      // instrumenting constants.
      if (isInstrumentsConstant(I)) {
        continue;
      }
      Alive.insert($AddrOf(I));
      Worklist.push_back($AddrOf(I));
    }
  }
  
  // Propagate liveness backwards to operands.  Keep track of live debug info
  // scopes.
  SmallPtrSet</*const*/ Metadata /*P*/ > AliveScopes/*J*/= new SmallPtrSet</*const*/ Metadata /*P*/ >(DenseMapInfo$LikePtr.$Info(), 32);
  while (!Worklist.empty()) {
    Instruction /*P*/ Curr = Worklist.pop_back_val();
    {
      
      // Collect the live debug info scopes attached to this instruction.
      /*const*/ DILocation /*P*/ DL = Curr.getDebugLoc().$DILocation$P();
      if ((DL != null)) {
        collectLiveScopes_DILocation$C_SmallPtrSetImpl$Metadata$C$P($Deref(DL), AliveScopes);
      }
    }
    
    for (final Use /*&*/ OI : Curr.operands()) {
      {
        Instruction /*P*/ Inst = dyn_cast_Instruction(OI);
        if ((Inst != null)) {
          if (Alive.insert(Inst).second) {
            Worklist.push_back(Inst);
          }
        }
      }
    }
  }
  
  // The inverse of the live set is the dead set.  These are those instructions
  // which have no side effects and do not influence the control flow or return
  // value of the function, and may therefore be deleted safely.
  // NOTE: We reuse the Worklist vector here for memory efficiency.
  for (final Instruction /*&*/ I : instructions_Function(F)) {
    // Check if the instruction is alive.
    if ((Alive.count($AddrOf(I)) != 0)) {
      continue;
    }
    {
      
      DbgInfoIntrinsic /*P*/ DII = dyn_cast_DbgInfoIntrinsic($AddrOf(I));
      if ((DII != null)) {
        // Check if the scope of this variable location is alive.
        if ((AliveScopes.count(DII.getDebugLoc().$arrow().getScope()) != 0)) {
          continue;
        }
        
        // Fallthrough and drop the intrinsic.
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"adce")) {
            {
              {
                Value /*P*/ V = DII.getVariableLocation();
                if ((V != null)) {
                  {
                    Instruction /*P*/ II = dyn_cast_Instruction(V);
                    if ((II != null)) {
                      if ((Alive.count(II) != 0)) {
                        $out_raw_ostream_Value$C(dbgs().$out(/*KEEP_STR*/"Dropping debug info for "), $Deref(DII)).$out(/*KEEP_STR*/$LF);
                      }
                    }
                  }
                }
              }
            }
            ;
          }
        } while (false);
      }
    }
    
    // Prepare to delete.
    Worklist.push_back($AddrOf(I));
    I.dropAllReferences();
  }
  
  for (final Instruction /*P*/ /*&*/ I : Worklist) {
    NumRemoved.$preInc();
    I.eraseFromParent();
  }
  
  return !Worklist.empty();
}

//<editor-fold defaultstate="collapsed" desc="initializeADCELegacyPassPassOnce">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp", line = 179,
 FQN="initializeADCELegacyPassPassOnce", NM="_ZL32initializeADCELegacyPassPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZL32initializeADCELegacyPassPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeADCELegacyPassPassOnce(final PassRegistry /*&*/ Registry) {
  PassInfo /*P*/ PI = new PassInfo($("Aggressive Dead Code Elimination"), $("adce"), ADCELegacyPass.class/*$AddrOf(ADCELegacyPass.ID)*/,
          ()->IrLlvmGlobals.callDefaultCtor(ADCELegacyPass.class), false, false);
  Registry.registerPass($Deref(PI), true);
  return PI;
}

//<editor-fold defaultstate="collapsed" desc="InitializeADCELegacyPassPassFlag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp", line = 179,
 FQN="InitializeADCELegacyPassPassFlag", NM="_ZL32InitializeADCELegacyPassPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZL32InitializeADCELegacyPassPassFlag")
//</editor-fold>
public static std.once_flag InitializeADCELegacyPassPassFlag/*J*/= new std.once_flag();
} // END OF class ADCEStatics
