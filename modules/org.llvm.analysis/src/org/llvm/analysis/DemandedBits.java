/**
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

package org.llvm.analysis;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.APInt;
import org.llvm.adt.SmallPtrSet;
import org.llvm.adt.aliases.DenseMap;
import org.llvm.adt.aliases.DenseMapInfo$LikePtr;
import org.llvm.adt.aliases.DenseMapIterator;
import org.llvm.adt.aliases.SmallVector;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.impl.*;
import static org.llvm.analysis.impl.DemandedBitsStatics.*;
import org.llvm.ir.intrinsic.ID;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.pass.IrLlvmGlobals.$out_raw_ostream_Value$C;
import static org.llvm.pass.IrLlvmGlobals.instructions_Function;
import static org.llvm.support.AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C;

//<editor-fold defaultstate="collapsed" desc="llvm::DemandedBits">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DemandedBits.h", line = 39,
 FQN="llvm::DemandedBits", NM="_ZN4llvm12DemandedBitsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm12DemandedBitsE")
//</editor-fold>
public class DemandedBits implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DemandedBits::DemandedBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DemandedBits.h", line = 41,
   FQN="llvm::DemandedBits::DemandedBits", NM="_ZN4llvm12DemandedBitsC1ERNS_8FunctionERNS_15AssumptionCacheERNS_13DominatorTreeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm12DemandedBitsC1ERNS_8FunctionERNS_15AssumptionCacheERNS_13DominatorTreeE")
  //</editor-fold>
  public DemandedBits(final Function /*&*/ F, final AssumptionCache /*&*/ AC, final DominatorTree /*&*/ DT) {
    // : F(F), AC(AC), DT(DT), Analyzed(false), Visited(), AliveBits() 
    //START JInit
    this./*&*/F=/*&*/F;
    this./*&*/AC=/*&*/AC;
    this./*&*/DT=/*&*/DT;
    this.Analyzed = false;
    this.Visited = new SmallPtrSet<Instruction /*P*/ >(DenseMapInfo$LikePtr.$Info(), 32);
    this.AliveBits = new DenseMap<Instruction /*P*/ , APInt>(DenseMapInfo$LikePtr.$Info(), new APInt());
    //END JInit
  }

  
  /// Return the bits demanded from instruction I.
  //<editor-fold defaultstate="collapsed" desc="llvm::DemandedBits::getDemandedBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp", line = 362,
   FQN="llvm::DemandedBits::getDemandedBits", NM="_ZN4llvm12DemandedBits15getDemandedBitsEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm12DemandedBits15getDemandedBitsEPNS_11InstructionE")
  //</editor-fold>
  public APInt getDemandedBits(Instruction /*P*/ I) {
    performAnalysis();
    
    final /*const*/ DataLayout /*&*/ DL = I.getParent().getModule().getDataLayout();
    if ((AliveBits.count(I) != 0)) {
      return new APInt(AliveBits.$at_T1$C$R(I));
    }
    return APInt.getAllOnesValue($ulong2uint(DL.getTypeSizeInBits(I.getType())));
  }

  
  /// Return true if, during analysis, I could not be reached.
  //<editor-fold defaultstate="collapsed" desc="llvm::DemandedBits::isInstructionDead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp", line = 371,
   FQN="llvm::DemandedBits::isInstructionDead", NM="_ZN4llvm12DemandedBits17isInstructionDeadEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm12DemandedBits17isInstructionDeadEPNS_11InstructionE")
  //</editor-fold>
  public boolean isInstructionDead(Instruction /*P*/ I) {
    performAnalysis();
    
    return !(Visited.count(I) != 0) && AliveBits.find(I).$eq(/*NO_ITER_COPY*/AliveBits.end())
       && !isAlwaysLive(I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DemandedBits::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp", line = 378,
   FQN="llvm::DemandedBits::print", NM="_ZN4llvm12DemandedBits5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm12DemandedBits5printERNS_11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) {
    performAnalysis();
    for (final std.pair<Instruction /*P*/ , APInt> /*&*/ KV : AliveBits) {
      $out_raw_ostream_Value$C(OS.$out(/*KEEP_STR*/"DemandedBits: 0x").$out(utohexstr(KV.second.getLimitedValue())).$out(/*KEEP_STR*/" for "), 
          $Deref(KV.first)).$out(/*KEEP_STR*/$LF);
    }
  }

/*private:*/
  private final Function /*&*/ F;
  private final AssumptionCache /*&*/ AC;
  private final DominatorTree /*&*/ DT;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DemandedBits::performAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp", line = 261,
   FQN="llvm::DemandedBits::performAnalysis", NM="_ZN4llvm12DemandedBits15performAnalysisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm12DemandedBits15performAnalysisEv")
  //</editor-fold>
  private void performAnalysis() {
    if (Analyzed) {
      // Analysis already completed for this function.
      return;
    }
    Analyzed = true;
    
    Visited.clear();
    AliveBits.clear();
    
    SmallVector<Instruction /*P*/ > Worklist/*J*/= new SmallVector<Instruction /*P*/ >(128, (Instruction /*P*/ )null);
    
    // Collect the set of "root" instructions that are known live.
    for (final Instruction /*&*/ I : instructions_Function(F)) {
      if (!isAlwaysLive($AddrOf(I))) {
        continue;
      }
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"demanded-bits")) {
          $out_raw_ostream_Value$C(dbgs().$out(/*KEEP_STR*/"DemandedBits: Root: "), I).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
      {
        // For integer-valued instructions, set up an initial empty set of alive
        // bits and add the instruction to the work list. For other instructions
        // add their operands to the work list (for integer values operands, mark
        // all bits as live).
        IntegerType /*P*/ IT = dyn_cast_IntegerType(I.getType());
        if ((IT != null)) {
          if (!(AliveBits.count($AddrOf(I)) != 0)) {
            AliveBits.$at_T1$RR($AddrOf(I)).$assignMove(new APInt(JD$UInt_ULong.INSTANCE, IT.getBitWidth(), $int2ulong(0)));
            Worklist.push_back($AddrOf(I));
          }
          
          continue;
        }
      }
      
      // Non-integer-typed instructions...
      for (final Use /*&*/ OI : I.operands()) {
        {
          Instruction /*P*/ J = dyn_cast_Instruction(OI);
          if ((J != null)) {
            {
              IntegerType /*P*/ IT = dyn_cast_IntegerType(J.getType());
              if ((IT != null)) {
                AliveBits.$at_T1$C$R(J).$assignMove(APInt.getAllOnesValue(IT.getBitWidth()));
              }
            }
            Worklist.push_back(J);
          }
        }
      }
      // To save memory, we don't add I to the Visited set here. Instead, we
      // check isAlwaysLive on every instruction when searching for dead
      // instructions later (we need to check isAlwaysLive for the
      // integer-typed instructions anyway).
    }
    
    // Propagate liveness backwards to operands.
    while (!Worklist.empty()) {
      Instruction /*P*/ UserI = Worklist.pop_back_val();
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"demanded-bits")) {
          $out_raw_ostream_Value$C(dbgs().$out(/*KEEP_STR*/"DemandedBits: Visiting: "), $Deref(UserI));
        }
      } while (false);
      APInt AOut/*J*/= new APInt();
      if (UserI.getType().isIntegerTy()) {
        AOut.$assign(AliveBits.$at_T1$C$R(UserI));
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"demanded-bits")) {
            $out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/" Alive Out: "), AOut);
          }
        } while (false);
      }
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"demanded-bits")) {
          dbgs().$out(/*KEEP_STR*/$LF);
        }
      } while (false);
      if (!UserI.getType().isIntegerTy()) {
        Visited.insert(UserI);
      }
      
      APInt KnownZero/*J*/= new APInt();
      APInt KnownOne/*J*/= new APInt();
      APInt KnownZero2/*J*/= new APInt();
      APInt KnownOne2/*J*/= new APInt();
      // Compute the set of alive bits for each operand. These are anded into the
      // existing set, if any, and if that changes the set of alive bits, the
      // operand is added to the work-list.
      for (final Use /*&*/ OI : UserI.operands()) {
        {
          Instruction /*P*/ I = dyn_cast_Instruction(OI);
          if ((I != null)) {
            {
              IntegerType /*P*/ IT = dyn_cast_IntegerType(I.getType());
              if ((IT != null)) {
                /*uint*/int BitWidth = IT.getBitWidth();
                APInt AB = APInt.getAllOnesValue(BitWidth);
                if (UserI.getType().isIntegerTy() && AOut.$not()
                   && !isAlwaysLive(UserI)) {
                  AB.$assignMove(new APInt(JD$UInt_ULong.INSTANCE, BitWidth, $int2ulong(0)));
                } else {
                  // If all bits of the output are dead, then all bits of the input
                  // Bits of each operand that are used to compute alive bits of the
                  // output are alive, all others are dead.
                  determineLiveOperandBits(UserI, I, OI.getOperandNo(), AOut, AB, 
                      KnownZero, KnownOne, 
                      KnownZero2, KnownOne2);
                }
                
                // If we've added to the set of alive bits (or the operand has not
                // been previously visited), then re-queue the operand to be visited
                // again.
                APInt ABPrev/*J*/= new APInt(JD$UInt_ULong.INSTANCE, BitWidth, $int2ulong(0));
                DenseMapIterator<Instruction /*P*/ , APInt> ABI = AliveBits.find(I);
                if (ABI.$noteq(/*NO_ITER_COPY*/AliveBits.end())) {
                  ABPrev.$assign(ABI.$arrow().second);
                }
                
                APInt ABNew = AB.$bitor(ABPrev);
                if (ABNew.$noteq(ABPrev) || ABI.$eq(/*NO_ITER_COPY*/AliveBits.end())) {
                  AliveBits.$at_T1$C$R(I).$assignMove(std.move(ABNew));
                  Worklist.push_back(I);
                }
              } else if (!(Visited.count(I) != 0)) {
                Worklist.push_back(I);
              }
            }
          }
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DemandedBits::determineLiveOperandBits">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp", line = 73,
   FQN="llvm::DemandedBits::determineLiveOperandBits", NM="_ZN4llvm12DemandedBits24determineLiveOperandBitsEPKNS_11InstructionES3_jRKNS_5APIntERS4_S7_S7_S7_S7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm12DemandedBits24determineLiveOperandBitsEPKNS_11InstructionES3_jRKNS_5APIntERS4_S7_S7_S7_S7_")
  //</editor-fold>
  private void determineLiveOperandBits(/*const*/ Instruction /*P*/ UserI, /*const*/ Instruction /*P*/ I, /*uint*/int OperandNo, 
                          final /*const*/ APInt /*&*/ AOut, final APInt /*&*/ AB, final APInt /*&*/ KnownZero, final APInt /*&*/ KnownOne, 
                          final APInt /*&*/ KnownZero2, final APInt /*&*/ KnownOne2) {
    /*uint*/int BitWidth = AB.getBitWidth();
    
    // We're called once per operand, but for some instructions, we need to
    // compute known bits of both operands in order to determine the live bits of
    // either (when both operands are instructions themselves). We don't,
    // however, want to do this twice, so we cache the result in APInts that live
    // in the caller. For the two-relevant-operands case, both operand values are
    // provided here.
    UIntValueValue2Void ComputeKnownBits = /*[&, &I, &KnownZero, &KnownOne, this, &UserI, &KnownZero2, &KnownOne2]*/ (/*uint*/int BitWidth$1, /*const*/ Value /*P*/ V1, /*const*/ Value /*P*/ V2) -> {
          final /*const*/ DataLayout /*&*/ DL = I.getModule$Const().getDataLayout();
          KnownZero.$assignMove(new APInt(JD$UInt_ULong.INSTANCE, BitWidth$1, $int2ulong(0)));
          KnownOne.$assignMove(new APInt(JD$UInt_ULong.INSTANCE, BitWidth$1, $int2ulong(0)));
          ValueTrackingLlvmGlobals.computeKnownBits(((/*const_cast*/Value /*P*/ )(V1)), KnownZero, KnownOne, DL, 0, 
              $AddrOf(AC), UserI, $AddrOf(DT));
          if ((V2 != null)) {
            KnownZero2.$assignMove(new APInt(JD$UInt_ULong.INSTANCE, BitWidth$1, $int2ulong(0)));
            KnownOne2.$assignMove(new APInt(JD$UInt_ULong.INSTANCE, BitWidth$1, $int2ulong(0)));
            ValueTrackingLlvmGlobals.computeKnownBits(((/*const_cast*/Value /*P*/ )(V2)), KnownZero2, KnownOne2, DL, 
                0, $AddrOf(AC), UserI, $AddrOf(DT));
          }
        };
    switch (UserI.getOpcode()) {
     default:
      break;
     case Instruction.OtherOps.Call:
     case Instruction.TermOps.Invoke:
      {
        /*const*/ IntrinsicInst /*P*/ II = dyn_cast_IntrinsicInst(UserI);
        if ((II != null)) {
          switch (II.getIntrinsicID()) {
           default:
            break;
           case ID.bswap:
            // The alive bits of the input are the swapped alive bits of
            // the output.
            AB.$assignMove(AOut.byteSwap());
            break;
           case ID.ctlz:
            if (OperandNo == 0) {
              // We need some output bits, so we need all bits of the
              // input to the left of, and including, the leftmost bit
              // known to be one.
              ComputeKnownBits.$call(BitWidth, I, (/*const*/ Value /*P*/ )null);
              AB.$assignMove(APInt.getHighBitsSet(BitWidth, 
                      std.min_uint(BitWidth, KnownOne.countLeadingZeros() + 1)));
            }
            break;
           case ID.cttz:
            if (OperandNo == 0) {
              // We need some output bits, so we need all bits of the
              // input to the right of, and including, the rightmost bit
              // known to be one.
              ComputeKnownBits.$call(BitWidth, I, (/*const*/ Value /*P*/ )null);
              AB.$assignMove(APInt.getLowBitsSet(BitWidth, 
                      std.min_uint(BitWidth, KnownOne.countTrailingZeros() + 1)));
            }
            break;
          }
        }
      }
      break;
     case Instruction.BinaryOps.Add:
     case Instruction.BinaryOps.Sub:
     case Instruction.BinaryOps.Mul:
      // Find the highest live output bit. We don't need any more input
      // bits than that (adds, and thus subtracts, ripple only to the
      // left).
      AB.$assignMove(APInt.getLowBitsSet(BitWidth, AOut.getActiveBits()));
      break;
     case Instruction.BinaryOps.Shl:
      if (OperandNo == 0) {
        {
          ConstantInt /*P*/ CI = dyn_cast_ConstantInt(UserI.getOperand(1));
          if ((CI != null)) {
            long/*uint64_t*/ ShiftAmt = CI.getLimitedValue($uint2ulong(BitWidth - 1));
            AB.$assignMove(AOut.lshr($ulong2uint(ShiftAmt)));
            
            // If the shift is nuw/nsw, then the high bits are not dead
            // (because we've promised that they *must* be zero).
            /*const*/ ShlOperator /*P*/ S = cast_ShlOperator(UserI);
            if (S.hasNoSignedWrap()) {
              AB.$orassign(APInt.getHighBitsSet(BitWidth, $ullong2uint(ShiftAmt + $int2ullong(1))));
            } else if (S.hasNoUnsignedWrap()) {
              AB.$orassign(APInt.getHighBitsSet(BitWidth, $ulong2uint(ShiftAmt)));
            }
          }
        }
      }
      break;
     case Instruction.BinaryOps.LShr:
      if (OperandNo == 0) {
        {
          ConstantInt /*P*/ CI = dyn_cast_ConstantInt(UserI.getOperand(1));
          if ((CI != null)) {
            long/*uint64_t*/ ShiftAmt = CI.getLimitedValue($uint2ulong(BitWidth - 1));
            AB.$assignMove(AOut.shl($ulong2uint(ShiftAmt)));
            
            // If the shift is exact, then the low bits are not dead
            // (they must be zero).
            if (cast_LShrOperator(UserI).isExact()) {
              AB.$orassign(APInt.getLowBitsSet(BitWidth, $ulong2uint(ShiftAmt)));
            }
          }
        }
      }
      break;
     case Instruction.BinaryOps.AShr:
      if (OperandNo == 0) {
        {
          ConstantInt /*P*/ CI = dyn_cast_ConstantInt(UserI.getOperand(1));
          if ((CI != null)) {
            long/*uint64_t*/ ShiftAmt = CI.getLimitedValue($uint2ulong(BitWidth - 1));
            AB.$assignMove(AOut.shl($ulong2uint(ShiftAmt)));
            // Because the high input bit is replicated into the
            // high-order bits of the result, if we need any of those
            // bits, then we must keep the highest input bit.
            if ((AOut.$bitand(APInt.getHighBitsSet(BitWidth, $ulong2uint(ShiftAmt)))).
                getBoolValue()) {
              AB.setBit(BitWidth - 1);
            }
            
            // If the shift is exact, then the low bits are not dead
            // (they must be zero).
            if (cast_AShrOperator(UserI).isExact()) {
              AB.$orassign(APInt.getLowBitsSet(BitWidth, $ulong2uint(ShiftAmt)));
            }
          }
        }
      }
      break;
     case Instruction.BinaryOps.And:
      AB.$assign(AOut);
      
      // For bits that are known zero, the corresponding bits in the
      // other operand are dead (unless they're both zero, in which
      // case they can't both be dead, so just mark the LHS bits as
      // dead).
      if (OperandNo == 0) {
        ComputeKnownBits.$call(BitWidth, I, UserI.getOperand(1));
        AB.$andassign(KnownZero2.$bitnot());
      } else {
        if (!isa_Instruction(UserI.getOperand(0))) {
          ComputeKnownBits.$call(BitWidth, UserI.getOperand(0), I);
        }
        AB.$andassign((KnownZero.$bitand(KnownZero2.$bitnot())).$bitnot());
      }
      break;
     case Instruction.BinaryOps.Or:
      AB.$assign(AOut);
      
      // For bits that are known one, the corresponding bits in the
      // other operand are dead (unless they're both one, in which
      // case they can't both be dead, so just mark the LHS bits as
      // dead).
      if (OperandNo == 0) {
        ComputeKnownBits.$call(BitWidth, I, UserI.getOperand(1));
        AB.$andassign(KnownOne2.$bitnot());
      } else {
        if (!isa_Instruction(UserI.getOperand(0))) {
          ComputeKnownBits.$call(BitWidth, UserI.getOperand(0), I);
        }
        AB.$andassign((KnownOne.$bitand(KnownOne2.$bitnot())).$bitnot());
      }
      break;
     case Instruction.BinaryOps.Xor:
     case Instruction.OtherOps.PHI:
      AB.$assign(AOut);
      break;
     case Instruction.CastOps.Trunc:
      AB.$assignMove(AOut.zext(BitWidth));
      break;
     case Instruction.CastOps.ZExt:
      AB.$assignMove(AOut.trunc(BitWidth));
      break;
     case Instruction.CastOps.SExt:
      AB.$assignMove(AOut.trunc(BitWidth));
      // Because the high input bit is replicated into the
      // high-order bits of the result, if we need any of those
      // bits, then we must keep the highest input bit.
      if ((AOut.$bitand(APInt.getHighBitsSet(AOut.getBitWidth(), 
              AOut.getBitWidth() - BitWidth))).
          getBoolValue()) {
        AB.setBit(BitWidth - 1);
      }
      break;
     case Instruction.OtherOps.Select:
      if (OperandNo != 0) {
        AB.$assign(AOut);
      }
      break;
    }
  }

  
  private boolean Analyzed;
  
  // The set of visited instructions (non-integer-typed only).
  private SmallPtrSet<Instruction /*P*/ > Visited;
  private DenseMap<Instruction /*P*/ , APInt> AliveBits;
  //<editor-fold defaultstate="collapsed" desc="llvm::DemandedBits::DemandedBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DemandedBits.h", line = 39,
   FQN="llvm::DemandedBits::DemandedBits", NM="_ZN4llvm12DemandedBitsC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm12DemandedBitsC1EOS0_")
  //</editor-fold>
  public /*inline*/ DemandedBits(JD$Move _dparam, final DemandedBits /*&&*/$Prm0) {
    // : F(static_cast<DemandedBits &&>().F), AC(static_cast<DemandedBits &&>().AC), DT(static_cast<DemandedBits &&>().DT), Analyzed(static_cast<DemandedBits &&>().Analyzed), Visited(static_cast<DemandedBits &&>().Visited), AliveBits(static_cast<DemandedBits &&>().AliveBits) 
    //START JInit
    this./*&*/F=/*&*/$Prm0.F;
    this./*&*/AC=/*&*/$Prm0.AC;
    this./*&*/DT=/*&*/$Prm0.DT;
    this.Analyzed = $Prm0.Analyzed;
    this.Visited = new SmallPtrSet<Instruction /*P*/ >(JD$Move.INSTANCE, $Prm0.Visited);
    this.AliveBits = new DenseMap<Instruction /*P*/ , APInt>(JD$Move.INSTANCE, $Prm0.AliveBits);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DemandedBits::~DemandedBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DemandedBits.h", line = 39,
   FQN="llvm::DemandedBits::~DemandedBits", NM="_ZN4llvm12DemandedBitsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm12DemandedBitsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    AliveBits.$destroy();
    Visited.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "F=" + F // NOI18N
              + ", AC=" + AC // NOI18N
              + ", DT=" + DT // NOI18N
              + ", Analyzed=" + Analyzed // NOI18N
              + ", Visited=" + Visited // NOI18N
              + ", AliveBits=" + AliveBits; // NOI18N
  }
}
