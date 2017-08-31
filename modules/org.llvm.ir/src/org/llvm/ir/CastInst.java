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
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.llvm.ir.java.IrRTTI.*;


//===----------------------------------------------------------------------===//
//                               CastInst Class
//===----------------------------------------------------------------------===//

/// This is the base class for all instructions that perform data
/// casts. It is simply provided so that instruction category testing
/// can be performed with code like:
///
/// if (isa<CastInst>(Instr)) { ... }
/// @brief Base class of casting instructions.
//<editor-fold defaultstate="collapsed" desc="llvm::CastInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 564,
 FQN="llvm::CastInst", NM="_ZN4llvm8CastInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInstE")
//</editor-fold>
public class CastInst extends /*public*/ UnaryInstruction implements Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  //                                CastInst Class
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2326,
   FQN="llvm::CastInst::anchor", NM="_ZN4llvm8CastInst6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInst6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

/*protected:*/
  /// @brief Constructor with insert-before-instruction semantics for subclasses
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::CastInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 569,
   FQN="llvm::CastInst::CastInst", NM="_ZN4llvm8CastInstC1EPNS_4TypeEjPNS_5ValueERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInstC1EPNS_4TypeEjPNS_5ValueERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  protected CastInst(Type /*P*/ Ty, /*uint*/int iType, Value /*P*/ S) {
    this(Ty, iType, S, 
      new Twine(/*KEEP_STR*/$EMPTY), (Instruction /*P*/ )null);
  }
  protected CastInst(Type /*P*/ Ty, /*uint*/int iType, Value /*P*/ S, 
      final /*const*/ Twine /*&*/ NameStr/*= ""*/) {
    this(Ty, iType, S, 
      NameStr, (Instruction /*P*/ )null);
  }
  protected CastInst(Type /*P*/ Ty, /*uint*/int iType, Value /*P*/ S, 
      final /*const*/ Twine /*&*/ NameStr/*= ""*/, Instruction /*P*/ InsertBefore/*= null*/) {
    // : UnaryInstruction(Ty, iType, S, InsertBefore) 
    //START JInit
    super(Ty, iType, S, InsertBefore);
    //END JInit
    setName(NameStr);
  }

  /// @brief Constructor with insert-at-end-of-block semantics for subclasses
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::CastInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 575,
   FQN="llvm::CastInst::CastInst", NM="_ZN4llvm8CastInstC1EPNS_4TypeEjPNS_5ValueERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInstC1EPNS_4TypeEjPNS_5ValueERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  protected CastInst(Type /*P*/ Ty, /*uint*/int iType, Value /*P*/ S, 
      final /*const*/ Twine /*&*/ NameStr, BasicBlock /*P*/ InsertAtEnd) {
    // : UnaryInstruction(Ty, iType, S, InsertAtEnd) 
    //START JInit
    super(Ty, iType, S, InsertAtEnd);
    //END JInit
    setName(NameStr);
  }

/*public:*/
  /// Provides a way to construct any of the CastInst subclasses using an
  /// opcode instead of the subclass's constructor. The opcode must be in the
  /// CastOps category (Instruction::isCast(opcode) returns true). This
  /// constructor has insert-before-instruction semantics to automatically
  /// insert the new CastInst before InsertBefore (if it is non-null).
  /// @brief Construct any of the CastInst subclasses
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2646,
   FQN="llvm::CastInst::Create", NM="_ZN4llvm8CastInst6CreateENS_11Instruction7CastOpsEPNS_5ValueEPNS_4TypeERKNS_5TwineEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInst6CreateENS_11Instruction7CastOpsEPNS_5ValueEPNS_4TypeERKNS_5TwineEPS1_")
  //</editor-fold>
  public static CastInst /*P*/ Create(/*CastOps*/int op, Value /*P*/ S, Type /*P*/ Ty) {
    return Create(op, S, Ty, 
        new Twine(///< The type to which cast should be made
      /*KEEP_STR*/$EMPTY), (Instruction /*P*/ )null);
  }
  public static CastInst /*P*/ Create(/*CastOps*/int op, Value /*P*/ S, Type /*P*/ Ty, 
        final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Create(op, S, Ty, 
        Name, (Instruction /*P*/ )null);
  }
  public static CastInst /*P*/ Create(/*CastOps*/int op, Value /*P*/ S, Type /*P*/ Ty, 
        final /*const*/ Twine /*&*/ Name/*= ""*/, Instruction /*P*/ InsertBefore/*= null*/) {
    assert (castIsValid(op, S, Ty)) : "Invalid cast!";
    // Construct and return the appropriate CastInst subclass
    switch (op) {
     case CastOps.Trunc:
      return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new TruncInst(S, Ty, Name, InsertBefore);
       });
     case CastOps.ZExt:
      return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new ZExtInst(S, Ty, Name, InsertBefore);
       });
     case CastOps.SExt:
      return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new SExtInst(S, Ty, Name, InsertBefore);
       });
     case CastOps.FPTrunc:
      return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new FPTruncInst(S, Ty, Name, InsertBefore);
       });
     case CastOps.FPExt:
      return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new FPExtInst(S, Ty, Name, InsertBefore);
       });
     case CastOps.UIToFP:
      return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new UIToFPInst(S, Ty, Name, InsertBefore);
       });
     case CastOps.SIToFP:
      return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new SIToFPInst(S, Ty, Name, InsertBefore);
       });
     case CastOps.FPToUI:
      return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new FPToUIInst(S, Ty, Name, InsertBefore);
       });
     case CastOps.FPToSI:
      return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new FPToSIInst(S, Ty, Name, InsertBefore);
       });
     case CastOps.PtrToInt:
      return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new PtrToIntInst(S, Ty, Name, InsertBefore);
       });
     case CastOps.IntToPtr:
      return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new IntToPtrInst(S, Ty, Name, InsertBefore);
       });
     case CastOps.BitCast:
      return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new BitCastInst(S, Ty, Name, InsertBefore);
       });
     case CastOps.AddrSpaceCast:
      return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new AddrSpaceCastInst(S, Ty, Name, InsertBefore);
       });
     default:
      throw new llvm_unreachable("Invalid opcode provided");
    }
  }

  /// Provides a way to construct any of the CastInst subclasses using an
  /// opcode instead of the subclass's constructor. The opcode must be in the
  /// CastOps category. This constructor has insert-at-end-of-block semantics
  /// to automatically insert the new CastInst at the end of InsertAtEnd (if
  /// its non-null).
  /// @brief Construct any of the CastInst subclasses
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2668,
   FQN="llvm::CastInst::Create", NM="_ZN4llvm8CastInst6CreateENS_11Instruction7CastOpsEPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInst6CreateENS_11Instruction7CastOpsEPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static CastInst /*P*/ Create(/*CastOps*/int op, Value /*P*/ S, Type /*P*/ Ty, 
        final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ InsertAtEnd) {
    assert (castIsValid(op, S, Ty)) : "Invalid cast!";
    // Construct and return the appropriate CastInst subclass
    switch (op) {
     case CastOps.Trunc:
      return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new TruncInst(S, Ty, Name, InsertAtEnd);
       });
     case CastOps.ZExt:
      return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new ZExtInst(S, Ty, Name, InsertAtEnd);
       });
     case CastOps.SExt:
      return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new SExtInst(S, Ty, Name, InsertAtEnd);
       });
     case CastOps.FPTrunc:
      return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new FPTruncInst(S, Ty, Name, InsertAtEnd);
       });
     case CastOps.FPExt:
      return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new FPExtInst(S, Ty, Name, InsertAtEnd);
       });
     case CastOps.UIToFP:
      return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new UIToFPInst(S, Ty, Name, InsertAtEnd);
       });
     case CastOps.SIToFP:
      return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new SIToFPInst(S, Ty, Name, InsertAtEnd);
       });
     case CastOps.FPToUI:
      return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new FPToUIInst(S, Ty, Name, InsertAtEnd);
       });
     case CastOps.FPToSI:
      return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new FPToSIInst(S, Ty, Name, InsertAtEnd);
       });
     case CastOps.PtrToInt:
      return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new PtrToIntInst(S, Ty, Name, InsertAtEnd);
       });
     case CastOps.IntToPtr:
      return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new IntToPtrInst(S, Ty, Name, InsertAtEnd);
       });
     case CastOps.BitCast:
      return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new BitCastInst(S, Ty, Name, InsertAtEnd);
       });
     case CastOps.AddrSpaceCast:
      return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new AddrSpaceCastInst(S, Ty, Name, InsertAtEnd);
       });
     default:
      throw new llvm_unreachable("Invalid opcode provided");
    }
  }

  
  /// @brief Create a ZExt or BitCast cast instruction
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::CreateZExtOrBitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2690,
   FQN="llvm::CastInst::CreateZExtOrBitCast", NM="_ZN4llvm8CastInst19CreateZExtOrBitCastEPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInst19CreateZExtOrBitCastEPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static CastInst /*P*/ CreateZExtOrBitCast(Value /*P*/ S, Type /*P*/ Ty) {
    return CreateZExtOrBitCast(S, Ty, 
                     new Twine(///< The type to which cast should be made
      /*KEEP_STR*/$EMPTY), 
                     (Instruction /*P*/ )null);
  }
  public static CastInst /*P*/ CreateZExtOrBitCast(Value /*P*/ S, Type /*P*/ Ty, 
                     final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateZExtOrBitCast(S, Ty, 
                     Name, 
                     (Instruction /*P*/ )null);
  }
  public static CastInst /*P*/ CreateZExtOrBitCast(Value /*P*/ S, Type /*P*/ Ty, 
                     final /*const*/ Twine /*&*/ Name/*= ""*/, 
                     Instruction /*P*/ InsertBefore/*= null*/) {
    if (S.getType().getScalarSizeInBits() == Ty.getScalarSizeInBits()) {
      return Create(Instruction.CastOps.BitCast, S, Ty, Name, InsertBefore);
    }
    return Create(Instruction.CastOps.ZExt, S, Ty, Name, InsertBefore);
  }

  
  /// @brief Create a ZExt or BitCast cast instruction
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::CreateZExtOrBitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2698,
   FQN="llvm::CastInst::CreateZExtOrBitCast", NM="_ZN4llvm8CastInst19CreateZExtOrBitCastEPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInst19CreateZExtOrBitCastEPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static CastInst /*P*/ CreateZExtOrBitCast(Value /*P*/ S, Type /*P*/ Ty, 
                     final /*const*/ Twine /*&*/ Name, 
                     BasicBlock /*P*/ InsertAtEnd) {
    if (S.getType().getScalarSizeInBits() == Ty.getScalarSizeInBits()) {
      return Create(Instruction.CastOps.BitCast, S, Ty, Name, InsertAtEnd);
    }
    return Create(Instruction.CastOps.ZExt, S, Ty, Name, InsertAtEnd);
  }

  
  /// @brief Create a SExt or BitCast cast instruction
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::CreateSExtOrBitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2706,
   FQN="llvm::CastInst::CreateSExtOrBitCast", NM="_ZN4llvm8CastInst19CreateSExtOrBitCastEPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInst19CreateSExtOrBitCastEPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static CastInst /*P*/ CreateSExtOrBitCast(Value /*P*/ S, Type /*P*/ Ty) {
    return CreateSExtOrBitCast(S, Ty, 
                     new Twine(///< The type to which cast should be made
      /*KEEP_STR*/$EMPTY), 
                     (Instruction /*P*/ )null);
  }
  public static CastInst /*P*/ CreateSExtOrBitCast(Value /*P*/ S, Type /*P*/ Ty, 
                     final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateSExtOrBitCast(S, Ty, 
                     Name, 
                     (Instruction /*P*/ )null);
  }
  public static CastInst /*P*/ CreateSExtOrBitCast(Value /*P*/ S, Type /*P*/ Ty, 
                     final /*const*/ Twine /*&*/ Name/*= ""*/, 
                     Instruction /*P*/ InsertBefore/*= null*/) {
    if (S.getType().getScalarSizeInBits() == Ty.getScalarSizeInBits()) {
      return Create(Instruction.CastOps.BitCast, S, Ty, Name, InsertBefore);
    }
    return Create(Instruction.CastOps.SExt, S, Ty, Name, InsertBefore);
  }

  
  /// @brief Create a SExt or BitCast cast instruction
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::CreateSExtOrBitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2714,
   FQN="llvm::CastInst::CreateSExtOrBitCast", NM="_ZN4llvm8CastInst19CreateSExtOrBitCastEPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInst19CreateSExtOrBitCastEPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static CastInst /*P*/ CreateSExtOrBitCast(Value /*P*/ S, Type /*P*/ Ty, 
                     final /*const*/ Twine /*&*/ Name, 
                     BasicBlock /*P*/ InsertAtEnd) {
    if (S.getType().getScalarSizeInBits() == Ty.getScalarSizeInBits()) {
      return Create(Instruction.CastOps.BitCast, S, Ty, Name, InsertAtEnd);
    }
    return Create(Instruction.CastOps.SExt, S, Ty, Name, InsertAtEnd);
  }

  
  /// @brief Create a BitCast AddrSpaceCast, or a PtrToInt cast instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::CreatePointerCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2738,
   FQN="llvm::CastInst::CreatePointerCast", NM="_ZN4llvm8CastInst17CreatePointerCastEPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInst17CreatePointerCastEPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static CastInst /*P*/ CreatePointerCast(Value /*P*/ S, Type /*P*/ Ty, 
                   final /*const*/ Twine /*&*/ Name, 
                   BasicBlock /*P*/ InsertAtEnd) {
    assert (S.getType().isPtrOrPtrVectorTy()) : "Invalid cast";
    assert ((Ty.isIntOrIntVectorTy() || Ty.isPtrOrPtrVectorTy())) : "Invalid cast";
    assert (Ty.isVectorTy() == S.getType().isVectorTy()) : "Invalid cast";
    assert ((!Ty.isVectorTy() || Ty.getVectorNumElements() == S.getType().getVectorNumElements())) : "Invalid cast";
    if (Ty.isIntOrIntVectorTy()) {
      return Create(Instruction.CastOps.PtrToInt, S, Ty, Name, InsertAtEnd);
    }
    
    return CreatePointerBitCastOrAddrSpaceCast(S, Ty, Name, InsertAtEnd);
  }

  
  /// @brief Create a BitCast, AddrSpaceCast or a PtrToInt cast instruction.
  
  /// @brief Create a BitCast or a PtrToInt cast instruction
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::CreatePointerCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2756,
   FQN="llvm::CastInst::CreatePointerCast", NM="_ZN4llvm8CastInst17CreatePointerCastEPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInst17CreatePointerCastEPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static CastInst /*P*/ CreatePointerCast(Value /*P*/ S, Type /*P*/ Ty) {
    return CreatePointerCast(S, Ty, 
                   new Twine(///< The type to which cast should be made
      /*KEEP_STR*/$EMPTY), 
                   (Instruction /*P*/ )null);
  }
  public static CastInst /*P*/ CreatePointerCast(Value /*P*/ S, Type /*P*/ Ty, 
                   final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreatePointerCast(S, Ty, 
                   Name, 
                   (Instruction /*P*/ )null);
  }
  public static CastInst /*P*/ CreatePointerCast(Value /*P*/ S, Type /*P*/ Ty, 
                   final /*const*/ Twine /*&*/ Name/*= ""*/, 
                   Instruction /*P*/ InsertBefore/*= null*/) {
    assert (S.getType().isPtrOrPtrVectorTy()) : "Invalid cast";
    assert ((Ty.isIntOrIntVectorTy() || Ty.isPtrOrPtrVectorTy())) : "Invalid cast";
    assert (Ty.isVectorTy() == S.getType().isVectorTy()) : "Invalid cast";
    assert ((!Ty.isVectorTy() || Ty.getVectorNumElements() == S.getType().getVectorNumElements())) : "Invalid cast";
    if (Ty.isIntOrIntVectorTy()) {
      return Create(Instruction.CastOps.PtrToInt, S, Ty, Name, InsertBefore);
    }
    
    return CreatePointerBitCastOrAddrSpaceCast(S, Ty, Name, InsertBefore);
  }

  
  /// @brief Create a BitCast or an AddrSpaceCast cast instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::CreatePointerBitCastOrAddrSpaceCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2773,
   FQN="llvm::CastInst::CreatePointerBitCastOrAddrSpaceCast", NM="_ZN4llvm8CastInst35CreatePointerBitCastOrAddrSpaceCastEPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInst35CreatePointerBitCastOrAddrSpaceCastEPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static CastInst /*P*/ CreatePointerBitCastOrAddrSpaceCast(Value /*P*/ S, Type /*P*/ Ty, 
                                     final /*const*/ Twine /*&*/ Name, 
                                     BasicBlock /*P*/ InsertAtEnd) {
    assert (S.getType().isPtrOrPtrVectorTy()) : "Invalid cast";
    assert (Ty.isPtrOrPtrVectorTy()) : "Invalid cast";
    if (S.getType().getPointerAddressSpace() != Ty.getPointerAddressSpace()) {
      return Create(Instruction.CastOps.AddrSpaceCast, S, Ty, Name, InsertAtEnd);
    }
    
    return Create(Instruction.CastOps.BitCast, S, Ty, Name, InsertAtEnd);
  }

  
  /// @brief Create a BitCast or an AddrSpaceCast cast instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::CreatePointerBitCastOrAddrSpaceCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2786,
   FQN="llvm::CastInst::CreatePointerBitCastOrAddrSpaceCast", NM="_ZN4llvm8CastInst35CreatePointerBitCastOrAddrSpaceCastEPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInst35CreatePointerBitCastOrAddrSpaceCastEPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static CastInst /*P*/ CreatePointerBitCastOrAddrSpaceCast(Value /*P*/ S, Type /*P*/ Ty) {
    return CreatePointerBitCastOrAddrSpaceCast(S, Ty, 
                                     new Twine(///< The type to which cast should be made
      /*KEEP_STR*/$EMPTY), 
                                     (Instruction /*P*/ )null);
  }
  public static CastInst /*P*/ CreatePointerBitCastOrAddrSpaceCast(Value /*P*/ S, Type /*P*/ Ty, 
                                     final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreatePointerBitCastOrAddrSpaceCast(S, Ty, 
                                     Name, 
                                     (Instruction /*P*/ )null);
  }
  public static CastInst /*P*/ CreatePointerBitCastOrAddrSpaceCast(Value /*P*/ S, Type /*P*/ Ty, 
                                     final /*const*/ Twine /*&*/ Name/*= ""*/, 
                                     Instruction /*P*/ InsertBefore/*= null*/) {
    assert (S.getType().isPtrOrPtrVectorTy()) : "Invalid cast";
    assert (Ty.isPtrOrPtrVectorTy()) : "Invalid cast";
    if (S.getType().getPointerAddressSpace() != Ty.getPointerAddressSpace()) {
      return Create(Instruction.CastOps.AddrSpaceCast, S, Ty, Name, InsertBefore);
    }
    
    return Create(Instruction.CastOps.BitCast, S, Ty, Name, InsertBefore);
  }

  
  /// @brief Create a BitCast, a PtrToInt, or an IntToPTr cast instruction.
  ///
  /// If the value is a pointer type and the destination an integer type,
  /// creates a PtrToInt cast. If the value is an integer type and the
  /// destination a pointer type, creates an IntToPtr cast. Otherwise, creates
  /// a bitcast.
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::CreateBitOrPointerCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2799,
   FQN="llvm::CastInst::CreateBitOrPointerCast", NM="_ZN4llvm8CastInst22CreateBitOrPointerCastEPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInst22CreateBitOrPointerCastEPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static CastInst /*P*/ CreateBitOrPointerCast(Value /*P*/ S, Type /*P*/ Ty) {
    return CreateBitOrPointerCast(S, Ty, 
                        new Twine(///< The type to which cast should be made
      /*KEEP_STR*/$EMPTY), 
                        (Instruction /*P*/ )null);
  }
  public static CastInst /*P*/ CreateBitOrPointerCast(Value /*P*/ S, Type /*P*/ Ty, 
                        final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateBitOrPointerCast(S, Ty, 
                        Name, 
                        (Instruction /*P*/ )null);
  }
  public static CastInst /*P*/ CreateBitOrPointerCast(Value /*P*/ S, Type /*P*/ Ty, 
                        final /*const*/ Twine /*&*/ Name/*= ""*/, 
                        Instruction /*P*/ InsertBefore/*= null*/) {
    if (S.getType().isPointerTy() && Ty.isIntegerTy()) {
      return Create(Instruction.CastOps.PtrToInt, S, Ty, Name, InsertBefore);
    }
    if (S.getType().isIntegerTy() && Ty.isPointerTy()) {
      return Create(Instruction.CastOps.IntToPtr, S, Ty, Name, InsertBefore);
    }
    
    return Create(Instruction.CastOps.BitCast, S, Ty, Name, InsertBefore);
  }

  
  /// @brief Create a ZExt, BitCast, or Trunc for int -> int casts.
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::CreateIntegerCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2810,
   FQN="llvm::CastInst::CreateIntegerCast", NM="_ZN4llvm8CastInst17CreateIntegerCastEPNS_5ValueEPNS_4TypeEbRKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInst17CreateIntegerCastEPNS_5ValueEPNS_4TypeEbRKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static CastInst /*P*/ CreateIntegerCast(Value /*P*/ C, Type /*P*/ Ty, 
                   boolean isSigned) {
    return CreateIntegerCast(C, Ty, 
                   isSigned, new Twine(///< Whether to regard S as signed or not
      /*KEEP_STR*/$EMPTY), 
                   (Instruction /*P*/ )null);
  }
  public static CastInst /*P*/ CreateIntegerCast(Value /*P*/ C, Type /*P*/ Ty, 
                   boolean isSigned, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateIntegerCast(C, Ty, 
                   isSigned, Name, 
                   (Instruction /*P*/ )null);
  }
  public static CastInst /*P*/ CreateIntegerCast(Value /*P*/ C, Type /*P*/ Ty, 
                   boolean isSigned, final /*const*/ Twine /*&*/ Name/*= ""*/, 
                   Instruction /*P*/ InsertBefore/*= null*/) {
    assert (C.getType().isIntOrIntVectorTy() && Ty.isIntOrIntVectorTy()) : "Invalid integer cast";
    /*uint*/int SrcBits = C.getType().getScalarSizeInBits();
    /*uint*/int DstBits = Ty.getScalarSizeInBits();
    /*CastOps*/int opcode = (SrcBits == DstBits ? Instruction.CastOps.BitCast : ($greater_uint(SrcBits, DstBits) ? Instruction.CastOps.Trunc : (isSigned ? Instruction.CastOps.SExt : Instruction.CastOps.ZExt)));
    return Create(opcode, C, Ty, Name, InsertBefore);
  }

  
  /// @brief Create a ZExt, BitCast, or Trunc for int -> int casts.
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::CreateIntegerCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2824,
   FQN="llvm::CastInst::CreateIntegerCast", NM="_ZN4llvm8CastInst17CreateIntegerCastEPNS_5ValueEPNS_4TypeEbRKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInst17CreateIntegerCastEPNS_5ValueEPNS_4TypeEbRKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static CastInst /*P*/ CreateIntegerCast(Value /*P*/ C, Type /*P*/ Ty, 
                   boolean isSigned, final /*const*/ Twine /*&*/ Name, 
                   BasicBlock /*P*/ InsertAtEnd) {
    assert (C.getType().isIntOrIntVectorTy() && Ty.isIntOrIntVectorTy()) : "Invalid cast";
    /*uint*/int SrcBits = C.getType().getScalarSizeInBits();
    /*uint*/int DstBits = Ty.getScalarSizeInBits();
    /*CastOps*/int opcode = (SrcBits == DstBits ? Instruction.CastOps.BitCast : ($greater_uint(SrcBits, DstBits) ? Instruction.CastOps.Trunc : (isSigned ? Instruction.CastOps.SExt : Instruction.CastOps.ZExt)));
    return Create(opcode, C, Ty, Name, InsertAtEnd);
  }

  
  /// @brief Create an FPExt, BitCast, or FPTrunc for fp -> fp casts
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::CreateFPCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2838,
   FQN="llvm::CastInst::CreateFPCast", NM="_ZN4llvm8CastInst12CreateFPCastEPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInst12CreateFPCastEPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static CastInst /*P*/ CreateFPCast(Value /*P*/ C, Type /*P*/ Ty) {
    return CreateFPCast(C, Ty, 
              new Twine(///< The floating point type to cast to
      /*KEEP_STR*/$EMPTY), 
              (Instruction /*P*/ )null);
  }
  public static CastInst /*P*/ CreateFPCast(Value /*P*/ C, Type /*P*/ Ty, 
              final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateFPCast(C, Ty, 
              Name, 
              (Instruction /*P*/ )null);
  }
  public static CastInst /*P*/ CreateFPCast(Value /*P*/ C, Type /*P*/ Ty, 
              final /*const*/ Twine /*&*/ Name/*= ""*/, 
              Instruction /*P*/ InsertBefore/*= null*/) {
    assert (C.getType().isFPOrFPVectorTy() && Ty.isFPOrFPVectorTy()) : "Invalid cast";
    /*uint*/int SrcBits = C.getType().getScalarSizeInBits();
    /*uint*/int DstBits = Ty.getScalarSizeInBits();
    /*CastOps*/int opcode = (SrcBits == DstBits ? Instruction.CastOps.BitCast : ($greater_uint(SrcBits, DstBits) ? Instruction.CastOps.FPTrunc : Instruction.CastOps.FPExt));
    return Create(opcode, C, Ty, Name, InsertBefore);
  }

  
  /// @brief Create an FPExt, BitCast, or FPTrunc for fp -> fp casts
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::CreateFPCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2851,
   FQN="llvm::CastInst::CreateFPCast", NM="_ZN4llvm8CastInst12CreateFPCastEPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInst12CreateFPCastEPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static CastInst /*P*/ CreateFPCast(Value /*P*/ C, Type /*P*/ Ty, 
              final /*const*/ Twine /*&*/ Name, 
              BasicBlock /*P*/ InsertAtEnd) {
    assert (C.getType().isFPOrFPVectorTy() && Ty.isFPOrFPVectorTy()) : "Invalid cast";
    /*uint*/int SrcBits = C.getType().getScalarSizeInBits();
    /*uint*/int DstBits = Ty.getScalarSizeInBits();
    /*CastOps*/int opcode = (SrcBits == DstBits ? Instruction.CastOps.BitCast : ($greater_uint(SrcBits, DstBits) ? Instruction.CastOps.FPTrunc : Instruction.CastOps.FPExt));
    return Create(opcode, C, Ty, Name, InsertAtEnd);
  }

  
  /// @brief Create a Trunc or BitCast cast instruction
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::CreateTruncOrBitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2722,
   FQN="llvm::CastInst::CreateTruncOrBitCast", NM="_ZN4llvm8CastInst20CreateTruncOrBitCastEPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInst20CreateTruncOrBitCastEPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static CastInst /*P*/ CreateTruncOrBitCast(Value /*P*/ S, Type /*P*/ Ty) {
    return CreateTruncOrBitCast(S, Ty, 
                      new Twine(///< The type to which cast should be made
      /*KEEP_STR*/$EMPTY), 
                      (Instruction /*P*/ )null);
  }
  public static CastInst /*P*/ CreateTruncOrBitCast(Value /*P*/ S, Type /*P*/ Ty, 
                      final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateTruncOrBitCast(S, Ty, 
                      Name, 
                      (Instruction /*P*/ )null);
  }
  public static CastInst /*P*/ CreateTruncOrBitCast(Value /*P*/ S, Type /*P*/ Ty, 
                      final /*const*/ Twine /*&*/ Name/*= ""*/, 
                      Instruction /*P*/ InsertBefore/*= null*/) {
    if (S.getType().getScalarSizeInBits() == Ty.getScalarSizeInBits()) {
      return Create(Instruction.CastOps.BitCast, S, Ty, Name, InsertBefore);
    }
    return Create(Instruction.CastOps.Trunc, S, Ty, Name, InsertBefore);
  }

  
  /// @brief Create a Trunc or BitCast cast instruction
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::CreateTruncOrBitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2730,
   FQN="llvm::CastInst::CreateTruncOrBitCast", NM="_ZN4llvm8CastInst20CreateTruncOrBitCastEPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInst20CreateTruncOrBitCastEPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static CastInst /*P*/ CreateTruncOrBitCast(Value /*P*/ S, Type /*P*/ Ty, 
                      final /*const*/ Twine /*&*/ Name, 
                      BasicBlock /*P*/ InsertAtEnd) {
    if (S.getType().getScalarSizeInBits() == Ty.getScalarSizeInBits()) {
      return Create(Instruction.CastOps.BitCast, S, Ty, Name, InsertAtEnd);
    }
    return Create(Instruction.CastOps.Trunc, S, Ty, Name, InsertAtEnd);
  }

  
  /// @brief Check whether it is valid to call getCastOpcode for these types.
  
  // Check whether it is valid to call getCastOpcode for these types.
  // This routine must be kept in sync with getCastOpcode.
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::isCastable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2866,
   FQN="llvm::CastInst::isCastable", NM="_ZN4llvm8CastInst10isCastableEPNS_4TypeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInst10isCastableEPNS_4TypeES2_")
  //</editor-fold>
  public static boolean isCastable(Type /*P*/ SrcTy, Type /*P*/ DestTy) {
    if (!SrcTy.isFirstClassType() || !DestTy.isFirstClassType()) {
      return false;
    }
    if (SrcTy == DestTy) {
      return true;
    }
    {
      
      VectorType /*P*/ SrcVecTy = dyn_cast_VectorType(SrcTy);
      if ((SrcVecTy != null)) {
        {
          VectorType /*P*/ DestVecTy = dyn_cast_VectorType(DestTy);
          if ((DestVecTy != null)) {
            if (SrcVecTy.getNumElements() == DestVecTy.getNumElements()) {
              // An element by element cast.  Valid if casting the elements is valid.
              SrcTy = SrcVecTy.getElementType();
              DestTy = DestVecTy.getElementType();
            }
          }
        }
      }
    }
    
    // Get the bit sizes, we'll need these
    /*uint*/int SrcBits = SrcTy.getPrimitiveSizeInBits(); // 0 for ptr
    /*uint*/int DestBits = DestTy.getPrimitiveSizeInBits(); // 0 for ptr
    
    // Run through the possibilities ...
    if (DestTy.isIntegerTy()) { // Casting to integral
      if (SrcTy.isIntegerTy()) { // Casting from integral
        return true;
      }
      if (SrcTy.isFloatingPointTy()) { // Casting from floating pt
        return true;
      }
      if (SrcTy.isVectorTy()) { // Casting from vector
        return DestBits == SrcBits;
      }
      // Casting from something else
      return SrcTy.isPointerTy();
    }
    if (DestTy.isFloatingPointTy()) { // Casting to floating pt
      if (SrcTy.isIntegerTy()) { // Casting from integral
        return true;
      }
      if (SrcTy.isFloatingPointTy()) { // Casting from floating pt
        return true;
      }
      if (SrcTy.isVectorTy()) { // Casting from vector
        return DestBits == SrcBits;
      }
      // Casting from something else
      return false;
    }
    if (DestTy.isVectorTy()) { // Casting to vector
      return DestBits == SrcBits;
    }
    if (DestTy.isPointerTy()) { // Casting to pointer
      if (SrcTy.isPointerTy()) { // Casting from pointer
        return true;
      }
      return SrcTy.isIntegerTy(); // Casting from integral
    }
    if (DestTy.isX86_MMXTy()) {
      if (SrcTy.isVectorTy()) {
        return DestBits == SrcBits; // 64-bit vector to MMX
      }
      return false;
    } // Casting to something else
    return false;
  }

  
  /// @brief Check whether a bitcast between these types is valid
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::isBitCastable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2921,
   FQN="llvm::CastInst::isBitCastable", NM="_ZN4llvm8CastInst13isBitCastableEPNS_4TypeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInst13isBitCastableEPNS_4TypeES2_")
  //</editor-fold>
  public static boolean isBitCastable(Type /*P*/ SrcTy, Type /*P*/ DestTy) {
    if (!SrcTy.isFirstClassType() || !DestTy.isFirstClassType()) {
      return false;
    }
    if (SrcTy == DestTy) {
      return true;
    }
    {
      
      VectorType /*P*/ SrcVecTy = dyn_cast_VectorType(SrcTy);
      if ((SrcVecTy != null)) {
        {
          VectorType /*P*/ DestVecTy = dyn_cast_VectorType(DestTy);
          if ((DestVecTy != null)) {
            if (SrcVecTy.getNumElements() == DestVecTy.getNumElements()) {
              // An element by element cast. Valid if casting the elements is valid.
              SrcTy = SrcVecTy.getElementType();
              DestTy = DestVecTy.getElementType();
            }
          }
        }
      }
    }
    {
      
      PointerType /*P*/ DestPtrTy = dyn_cast_PointerType(DestTy);
      if ((DestPtrTy != null)) {
        {
          PointerType /*P*/ SrcPtrTy = dyn_cast_PointerType(SrcTy);
          if ((SrcPtrTy != null)) {
            return SrcPtrTy.getAddressSpace() == DestPtrTy.getAddressSpace();
          }
        }
      }
    }
    
    /*uint*/int SrcBits = SrcTy.getPrimitiveSizeInBits(); // 0 for ptr
    /*uint*/int DestBits = DestTy.getPrimitiveSizeInBits(); // 0 for ptr
    
    // Could still have vectors of pointers if the number of elements doesn't
    // match
    if (SrcBits == 0 || DestBits == 0) {
      return false;
    }
    if (SrcBits != DestBits) {
      return false;
    }
    if (DestTy.isX86_MMXTy() || SrcTy.isX86_MMXTy()) {
      return false;
    }
    
    return true;
  }

  
  /// @brief Check whether a bitcast, inttoptr, or ptrtoint cast between these
  /// types is valid and a no-op.
  ///
  /// This ensures that any pointer<->integer cast has enough bits in the
  /// integer and any other cast is a bitcast.
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::isBitOrNoopPointerCastable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2961,
   FQN="llvm::CastInst::isBitOrNoopPointerCastable", NM="_ZN4llvm8CastInst26isBitOrNoopPointerCastableEPNS_4TypeES2_RKNS_10DataLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInst26isBitOrNoopPointerCastableEPNS_4TypeES2_RKNS_10DataLayoutE")
  //</editor-fold>
  public static boolean isBitOrNoopPointerCastable(Type /*P*/ SrcTy, Type /*P*/ DestTy, 
                            final /*const*/ DataLayout /*&*/ DL) {
    {
      PointerType /*P*/ PtrTy = dyn_cast_PointerType(SrcTy);
      if ((PtrTy != null)) {
        {
          IntegerType /*P*/ IntTy = dyn_cast_IntegerType(DestTy);
          if ((IntTy != null)) {
            return IntTy.getBitWidth() == DL.getPointerTypeSizeInBits(PtrTy);
          }
        }
      }
    }
    {
      PointerType /*P*/ PtrTy = dyn_cast_PointerType(DestTy);
      if ((PtrTy != null)) {
        {
          IntegerType /*P*/ IntTy = dyn_cast_IntegerType(SrcTy);
          if ((IntTy != null)) {
            return IntTy.getBitWidth() == DL.getPointerTypeSizeInBits(PtrTy);
          }
        }
      }
    }
    
    return isBitCastable(SrcTy, DestTy);
  }

  
  /// Returns the opcode necessary to cast Val into Ty using usual casting
  /// rules.
  /// @brief Infer the opcode for cast operand and type
  
  // Provide a way to get a "cast" where the cast opcode is inferred from the
  // types and size of the operand. This, basically, is a parallel of the
  // logic in the castIsValid function below.  This axiom should hold:
  //   castIsValid( getCastOpcode(Val, Ty), Val, Ty)
  // should not assert in castIsValid. In other words, this produces a "correct"
  // casting opcode for the arguments passed to it.
  // This routine must be kept in sync with isCastable.
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::getCastOpcode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2980,
   FQN="llvm::CastInst::getCastOpcode", NM="_ZN4llvm8CastInst13getCastOpcodeEPKNS_5ValueEbPNS_4TypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInst13getCastOpcodeEPKNS_5ValueEbPNS_4TypeEb")
  //</editor-fold>
  public static /*CastOps*/int getCastOpcode(/*const*/ Value /*P*/ Src, boolean SrcIsSigned, Type /*P*/ DestTy, boolean DestIsSigned) {
    Type /*P*/ SrcTy = Src.getType();
    assert (SrcTy.isFirstClassType() && DestTy.isFirstClassType()) : "Only first class types are castable!";
    if (SrcTy == DestTy) {
      return CastOps.BitCast;
    }
    {
      
      // FIXME: Check address space sizes here
      VectorType /*P*/ SrcVecTy = dyn_cast_VectorType(SrcTy);
      if ((SrcVecTy != null)) {
        {
          VectorType /*P*/ DestVecTy = dyn_cast_VectorType(DestTy);
          if ((DestVecTy != null)) {
            if (SrcVecTy.getNumElements() == DestVecTy.getNumElements()) {
              // An element by element cast.  Find the appropriate opcode based on the
              // element types.
              SrcTy = SrcVecTy.getElementType();
              DestTy = DestVecTy.getElementType();
            }
          }
        }
      }
    }
    
    // Get the bit sizes, we'll need these
    /*uint*/int SrcBits = SrcTy.getPrimitiveSizeInBits(); // 0 for ptr
    /*uint*/int DestBits = DestTy.getPrimitiveSizeInBits(); // 0 for ptr
    
    // Run through the possibilities ...
    if (DestTy.isIntegerTy()) { // Casting to integral
      if (SrcTy.isIntegerTy()) { // Casting from integral
        if ($less_uint(DestBits, SrcBits)) {
          return CastOps.Trunc; // int -> smaller int
        } else if ($greater_uint(DestBits, SrcBits)) { // its an extension
          if (SrcIsSigned) {
            return CastOps.SExt; // signed -> SEXT
          } else {
            return CastOps.ZExt; // unsigned -> ZEXT
          }
        } else {
          return CastOps.BitCast; // Same size, No-op cast
        }
      } else if (SrcTy.isFloatingPointTy()) { // Casting from floating pt
        if (DestIsSigned) {
          return CastOps.FPToSI; // FP -> sint
        } else {
          return CastOps.FPToUI; // FP -> uint 
        }
      } else if (SrcTy.isVectorTy()) {
        assert (DestBits == SrcBits) : "Casting vector to integer of different width";
        return CastOps.BitCast; // Same size, no-op cast
      } else {
        assert (SrcTy.isPointerTy()) : "Casting from a value that is not first-class type";
        return CastOps.PtrToInt; // ptr -> int
      }
    } else if (DestTy.isFloatingPointTy()) { // Casting to floating pt
      if (SrcTy.isIntegerTy()) { // Casting from integral
        if (SrcIsSigned) {
          return CastOps.SIToFP; // sint -> FP
        } else {
          return CastOps.UIToFP; // uint -> FP
        }
      } else if (SrcTy.isFloatingPointTy()) { // Casting from floating pt
        if ($less_uint(DestBits, SrcBits)) {
          return CastOps.FPTrunc; // FP -> smaller FP
        } else if ($greater_uint(DestBits, SrcBits)) {
          return CastOps.FPExt; // FP -> larger FP
        } else {
          return CastOps.BitCast; // same size, no-op cast
        }
      } else if (SrcTy.isVectorTy()) {
        assert (DestBits == SrcBits) : "Casting vector to floating point of different width";
        return CastOps.BitCast; // same size, no-op cast
      }
      throw new llvm_unreachable("Casting pointer or non-first class to float");
    } else if (DestTy.isVectorTy()) {
      assert (DestBits == SrcBits) : "Illegal cast to vector (wrong type or size)";
      return CastOps.BitCast;
    } else if (DestTy.isPointerTy()) {
      if (SrcTy.isPointerTy()) {
        if (DestTy.getPointerAddressSpace() != SrcTy.getPointerAddressSpace()) {
          return CastOps.AddrSpaceCast;
        }
        return CastOps.BitCast; // ptr -> ptr
      } else if (SrcTy.isIntegerTy()) {
        return CastOps.IntToPtr; // int -> ptr
      }
      throw new llvm_unreachable("Casting pointer to other than pointer or int");
    } else if (DestTy.isX86_MMXTy()) {
      if (SrcTy.isVectorTy()) {
        assert (DestBits == SrcBits) : "Casting vector of wrong width to X86_MMX";
        return CastOps.BitCast; // 64-bit vector to MMX
      }
      throw new llvm_unreachable("Illegal cast to X86_MMX");
    }
    throw new llvm_unreachable("Casting to type that is not first-class");
  }

  
  /// There are several places where we need to know if a cast instruction
  /// only deals with integer source and destination types. To simplify that
  /// logic, this method is provided.
  /// @returns true iff the cast has only integral typed operand and dest type.
  /// @brief Determine if this is an integer-only cast.
  
  // Just determine if this cast only deals with integral->integral conversion.
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::isIntegerCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2329,
   FQN="llvm::CastInst::isIntegerCast", NM="_ZNK4llvm8CastInst13isIntegerCastEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CastInst13isIntegerCastEv")
  //</editor-fold>
  public boolean isIntegerCast() /*const*/ {
    switch (getOpcode()) {
     default:
      return false;
     case Instruction.CastOps.ZExt:
     case Instruction.CastOps.SExt:
     case Instruction.CastOps.Trunc:
      return true;
     case Instruction.CastOps.BitCast:
      return getOperand(0).getType().isIntegerTy()
         && getType().isIntegerTy();
    }
  }

  
  /// A lossless cast is one that does not alter the basic value. It implies
  /// a no-op cast but is more stringent, preventing things like int->float,
  /// long->double, or int->ptr.
  /// @returns true iff the cast is lossless.
  /// @brief Determine if this is a lossless cast.
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::isLosslessCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2342,
   FQN="llvm::CastInst::isLosslessCast", NM="_ZNK4llvm8CastInst14isLosslessCastEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CastInst14isLosslessCastEv")
  //</editor-fold>
  public boolean isLosslessCast() /*const*/ {
    // Only BitCast can be lossless, exit fast if we're not BitCast
    if (getOpcode() != Instruction.CastOps.BitCast) {
      return false;
    }
    
    // Identity cast is always lossless
    Type /*P*/ SrcTy = getOperand(0).getType();
    Type /*P*/ DstTy = getType();
    if (SrcTy == DstTy) {
      return true;
    }
    
    // Pointer to pointer is always lossless.
    if (SrcTy.isPointerTy()) {
      return DstTy.isPointerTy();
    }
    return false; // Other types have no identity values
  }

  
  /// A no-op cast is one that can be effected without changing any bits.
  /// It implies that the source and destination types are the same size. The
  /// IntPtrTy argument is used to make accurate determinations for casts
  /// involving Integer and Pointer types. They are no-op casts if the integer
  /// is the same size as the pointer. However, pointer size varies with
  /// platform. Generally, the result of DataLayout::getIntPtrType() should be
  /// passed in. If that's not available, use Type::Int64Ty, which will make
  /// the isNoopCast call conservative.
  /// @brief Determine if the described cast is a no-op cast.
  
  /// This function determines if the CastInst does not require any bits to be
  /// changed in order to effect the cast. Essentially, it identifies cases where
  /// no code gen is necessary for the cast, hence the name no-op cast.  For 
  /// example, the following are all no-op casts:
  /// # bitcast i32* %x to i8*
  /// # bitcast <2 x i32> %x to <4 x i16> 
  /// # ptrtoint i32* %x to i32     ; on 32-bit plaforms only
  /// @brief Determine if the described cast is a no-op.
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::isNoopCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2367,
   FQN="llvm::CastInst::isNoopCast", NM="_ZN4llvm8CastInst10isNoopCastENS_11Instruction7CastOpsEPNS_4TypeES4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInst10isNoopCastENS_11Instruction7CastOpsEPNS_4TypeES4_S4_")
  //</editor-fold>
  public static boolean isNoopCast(/*CastOps*/int Opcode, 
            Type /*P*/ SrcTy, 
            Type /*P*/ DestTy, 
            Type /*P*/ IntPtrTy) {
    switch (Opcode) {
     default:
      throw new llvm_unreachable("Invalid CastOp");
     case Instruction.CastOps.Trunc:
     case Instruction.CastOps.ZExt:
     case Instruction.CastOps.SExt:
     case Instruction.CastOps.FPTrunc:
     case Instruction.CastOps.FPExt:
     case Instruction.CastOps.UIToFP:
     case Instruction.CastOps.SIToFP:
     case Instruction.CastOps.FPToUI:
     case Instruction.CastOps.FPToSI:
     case Instruction.CastOps.AddrSpaceCast:
      // TODO: Target informations may give a more accurate answer here.
      return false;
     case Instruction.CastOps.BitCast:
      return true; // BitCast never modifies bits.
     case Instruction.CastOps.PtrToInt:
      return IntPtrTy.getScalarSizeInBits()
         == DestTy.getScalarSizeInBits();
     case Instruction.CastOps.IntToPtr:
      return IntPtrTy.getScalarSizeInBits()
         == SrcTy.getScalarSizeInBits();
    }
  }

  
  /// @brief Determine if this cast is a no-op cast.
  
  /// @brief Determine if a cast is a no-op.
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::isNoopCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2397,
   FQN="llvm::CastInst::isNoopCast", NM="_ZNK4llvm8CastInst10isNoopCastEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CastInst10isNoopCastEPNS_4TypeE")
  //</editor-fold>
  public boolean isNoopCast(Type /*P*/ IntPtrTy) /*const*/ {
    return isNoopCast(getOpcode(), getOperand(0).getType(), getType(), IntPtrTy);
  }

  
  /// @brief Determine if this cast is a no-op cast.
  ///
  /// \param DL is the DataLayout to get the Int Ptr type from.
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::isNoopCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2401,
   FQN="llvm::CastInst::isNoopCast", NM="_ZNK4llvm8CastInst10isNoopCastERKNS_10DataLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CastInst10isNoopCastERKNS_10DataLayoutE")
  //</editor-fold>
  public boolean isNoopCast(final /*const*/ DataLayout /*&*/ DL) /*const*/ {
    Type /*P*/ PtrOpTy = null;
    if (getOpcode() == Instruction.CastOps.PtrToInt) {
      PtrOpTy = getOperand(0).getType();
    } else if (getOpcode() == Instruction.CastOps.IntToPtr) {
      PtrOpTy = getType();
    }
    
    Type /*P*/ IntPtrTy = (PtrOpTy != null) ? DL.getIntPtrType(PtrOpTy) : DL.getIntPtrType(getContext(), 0);
    
    return isNoopCast(getOpcode(), getOperand(0).getType(), getType(), IntPtrTy);
  }

  
  /// Determine how a pair of casts can be eliminated, if they can be at all.
  /// This is a helper function for both CastInst and ConstantExpr.
  /// @returns 0 if the CastInst pair can't be eliminated, otherwise
  /// returns Instruction::CastOps value for a cast that can replace
  /// the pair, casting SrcTy to DstTy.
  /// @brief Determine if a cast pair is eliminable
  
  /// This function determines if a pair of casts can be eliminated and what
  /// opcode should be used in the elimination. This assumes that there are two
  /// instructions like this:
  /// *  %F = firstOpcode SrcTy %x to MidTy
  /// *  %S = secondOpcode MidTy %F to DstTy
  /// The function returns a resultOpcode so these two casts can be replaced with:
  /// *  %Replacement = resultOpcode %SrcTy %x to DstTy
  /// If no such cast is permitted, the function returns 0.
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::isEliminableCastPair">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2422,
   FQN="llvm::CastInst::isEliminableCastPair", NM="_ZN4llvm8CastInst20isEliminableCastPairENS_11Instruction7CastOpsES2_PNS_4TypeES4_S4_S4_S4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInst20isEliminableCastPairENS_11Instruction7CastOpsES2_PNS_4TypeES4_S4_S4_S4_S4_")
  //</editor-fold>
  public static /*uint*/int isEliminableCastPair(/*CastOps*/int firstOp, /*CastOps*/int secondOp, 
                      Type /*P*/ SrcTy, Type /*P*/ MidTy, Type /*P*/ DstTy, Type /*P*/ SrcIntPtrTy, Type /*P*/ MidIntPtrTy, 
                      Type /*P*/ DstIntPtrTy) {
    // Define the 144 possibilities for these two cast instructions. The values
    // in this matrix determine what to do in a given situation and select the
    // case in the switch below.  The rows correspond to firstOp, the columns 
    // correspond to secondOp.  In looking at the table below, keep in mind
    // the following cast properties:
    //
    //          Size Compare       Source               Destination
    // Operator  Src ? Size   Type       Sign         Type       Sign
    // -------- ------------ -------------------   ---------------------
    // TRUNC         >       Integer      Any        Integral     Any
    // ZEXT          <       Integral   Unsigned     Integer      Any
    // SEXT          <       Integral    Signed      Integer      Any
    // FPTOUI       n/a      FloatPt      n/a        Integral   Unsigned
    // FPTOSI       n/a      FloatPt      n/a        Integral    Signed
    // UITOFP       n/a      Integral   Unsigned     FloatPt      n/a
    // SITOFP       n/a      Integral    Signed      FloatPt      n/a
    // FPTRUNC       >       FloatPt      n/a        FloatPt      n/a
    // FPEXT         <       FloatPt      n/a        FloatPt      n/a
    // PTRTOINT     n/a      Pointer      n/a        Integral   Unsigned
    // INTTOPTR     n/a      Integral   Unsigned     Pointer      n/a
    // BITCAST       =       FirstClass   n/a       FirstClass    n/a
    // ADDRSPCST    n/a      Pointer      n/a        Pointer      n/a
    //
    // NOTE: some transforms are safe, but we consider them to be non-profitable.
    // For example, we could merge "fptoui double to i32" + "zext i32 to i64",
    // into "fptoui double to i64", but this loses information about the range
    // of the produced value (we no longer know the top-part is all zeros).
    // Further this conversion is often much more expensive for typical hardware,
    // and causes issues when building libgcc.  We disallow fptosi+sext for the
    // same reason.
    /*const*//*uint*/int numCastOps = Instruction.CastOps.CastOpsEnd - Instruction.CastOps.CastOpsBegin;
    final/*static*/ /*const*/byte/*uint8_t*/ CastResults[/*13*/][/*13*/] = isEliminableCastPair$$.CastResults;
    
    // TODO: This logic could be encoded into the table above and handled in the
    // switch below.
    // If either of the casts are a bitcast from scalar to vector, disallow the
    // merging. However, any pair of bitcasts are allowed.
    boolean IsFirstBitcast = (firstOp == Instruction.CastOps.BitCast);
    boolean IsSecondBitcast = (secondOp == Instruction.CastOps.BitCast);
    boolean AreBothBitcasts = IsFirstBitcast && IsSecondBitcast;
    
    // Check if any of the casts convert scalars <-> vectors.
    if ((IsFirstBitcast && isa_VectorType(SrcTy) != isa_VectorType(MidTy))
       || (IsSecondBitcast && isa_VectorType(MidTy) != isa_VectorType(DstTy))) {
      if (!AreBothBitcasts) {
        return 0;
      }
    }
    
    int ElimCase = $uchar2int(CastResults[firstOp - Instruction.CastOps.CastOpsBegin][secondOp - Instruction.CastOps.CastOpsBegin]);
    switch (ElimCase) {
     case 0:
      // Categorically disallowed.
      return 0;
     case 1:
      // Allowed, use first cast's opcode.
      return firstOp;
     case 2:
      // Allowed, use second cast's opcode.
      return secondOp;
     case 3:
      // No-op cast in second op implies firstOp as long as the DestTy
      // is integer and we are not converting between a vector and a
      // non-vector type.
      if (!SrcTy.isVectorTy() && DstTy.isIntegerTy()) {
        return firstOp;
      }
      return 0;
     case 4:
      // No-op cast in second op implies firstOp as long as the DestTy
      // is floating point.
      if (DstTy.isFloatingPointTy()) {
        return firstOp;
      }
      return 0;
     case 5:
      // No-op cast in first op implies secondOp as long as the SrcTy
      // is an integer.
      if (SrcTy.isIntegerTy()) {
        return secondOp;
      }
      return 0;
     case 6:
      // No-op cast in first op implies secondOp as long as the SrcTy
      // is a floating point.
      if (SrcTy.isFloatingPointTy()) {
        return secondOp;
      }
      return 0;
     case 7:
      {
        // Cannot simplify if address spaces are different!
        if (SrcTy.getPointerAddressSpace() != DstTy.getPointerAddressSpace()) {
          return 0;
        }
        
        /*uint*/int MidSize = MidTy.getScalarSizeInBits();
        // We can still fold this without knowing the actual sizes as long we
        // know that the intermediate pointer is the largest possible
        // pointer size.
        // FIXME: Is this always true?
        if (MidSize == 64) {
          return Instruction.CastOps.BitCast;
        }
        
        // ptrtoint, inttoptr -> bitcast (ptr -> ptr) if int size is >= ptr size.
        if (!(SrcIntPtrTy != null) || DstIntPtrTy != SrcIntPtrTy) {
          return 0;
        }
        /*uint*/int PtrSize = SrcIntPtrTy.getScalarSizeInBits();
        if ($greatereq_uint(MidSize, PtrSize)) {
          return Instruction.CastOps.BitCast;
        }
        return 0;
      }
     case 8:
      {
        // ext, trunc -> bitcast,    if the SrcTy and DstTy are same size
        // ext, trunc -> ext,        if sizeof(SrcTy) < sizeof(DstTy)
        // ext, trunc -> trunc,      if sizeof(SrcTy) > sizeof(DstTy)
        /*uint*/int SrcSize = SrcTy.getScalarSizeInBits();
        /*uint*/int DstSize = DstTy.getScalarSizeInBits();
        if (SrcSize == DstSize) {
          return Instruction.CastOps.BitCast;
        } else if ($less_uint(SrcSize, DstSize)) {
          return firstOp;
        }
        return secondOp;
      }
     case 9:
      // zext, sext -> zext, because sext can't sign extend after zext
      return Instruction.CastOps.ZExt;
     case 10:
      // fpext followed by ftrunc is allowed if the bit size returned to is
      // the same as the original, in which case its just a bitcast
      if (SrcTy == DstTy) {
        return Instruction.CastOps.BitCast;
      }
      return 0; // If the types are not the same we can't eliminate it.
     case 11:
      {
        // inttoptr, ptrtoint -> bitcast if SrcSize<=PtrSize and SrcSize==DstSize
        if (!(MidIntPtrTy != null)) {
          return 0;
        }
        /*uint*/int PtrSize = MidIntPtrTy.getScalarSizeInBits();
        /*uint*/int SrcSize = SrcTy.getScalarSizeInBits();
        /*uint*/int DstSize = DstTy.getScalarSizeInBits();
        if ($lesseq_uint(SrcSize, PtrSize) && SrcSize == DstSize) {
          return Instruction.CastOps.BitCast;
        }
        return 0;
      }
     case 12:
      {
        // addrspacecast, addrspacecast -> bitcast,       if SrcAS == DstAS
        // addrspacecast, addrspacecast -> addrspacecast, if SrcAS != DstAS
        if (SrcTy.getPointerAddressSpace() != DstTy.getPointerAddressSpace()) {
          return Instruction.CastOps.AddrSpaceCast;
        }
        return Instruction.CastOps.BitCast;
      }
     case 13:
      // FIXME: this state can be merged with (1), but the following assert
      // is useful to check the correcteness of the sequence due to semantic
      // change of bitcast.
      assert (SrcTy.isPtrOrPtrVectorTy() && MidTy.isPtrOrPtrVectorTy() && DstTy.isPtrOrPtrVectorTy() && SrcTy.getPointerAddressSpace() != MidTy.getPointerAddressSpace() && MidTy.getPointerAddressSpace() == DstTy.getPointerAddressSpace()) : "Illegal addrspacecast, bitcast sequence!";
      // Allowed, use first cast's opcode
      return firstOp;
     case 14:
      // bitcast, addrspacecast -> addrspacecast if the element type of
      // bitcast's source is the same as that of addrspacecast's destination.
      if (SrcTy.getPointerElementType() == DstTy.getPointerElementType()) {
        return Instruction.CastOps.AddrSpaceCast;
      }
      return 0;
     case 15:
      // FIXME: this state can be merged with (1), but the following assert
      // is useful to check the correcteness of the sequence due to semantic
      // change of bitcast.
      assert (SrcTy.isIntOrIntVectorTy() && MidTy.isPtrOrPtrVectorTy() && DstTy.isPtrOrPtrVectorTy() && MidTy.getPointerAddressSpace() == DstTy.getPointerAddressSpace()) : "Illegal inttoptr, bitcast sequence!";
      // Allowed, use first cast's opcode
      return firstOp;
     case 16:
      // FIXME: this state can be merged with (2), but the following assert
      // is useful to check the correcteness of the sequence due to semantic
      // change of bitcast.
      assert (SrcTy.isPtrOrPtrVectorTy() && MidTy.isPtrOrPtrVectorTy() && DstTy.isIntOrIntVectorTy() && SrcTy.getPointerAddressSpace() == MidTy.getPointerAddressSpace()) : "Illegal bitcast, ptrtoint sequence!";
      // Allowed, use second cast's opcode
      return secondOp;
     case 17:
      // (sitofp (zext x)) -> (uitofp x)
      return Instruction.CastOps.UIToFP;
     case 99:
      // Cast combination can't happen (error in input). This is for all cases
      // where the MidTy is not the same for the two cast instructions.
      throw new llvm_unreachable("Invalid Cast Combination");
     default:
      throw new llvm_unreachable("Error in CastResults table!!!");
    }
  }
  private static final class isEliminableCastPair$$ {
    static final/*static*/ /*const*/byte/*uint8_t*/ CastResults[/*13*/][/*13*/] = new /*const*/byte/*uint8_t*/ [/*13*/] [/*13*/] {
      // T        F  F  U  S  F  F  P  I  B  A  -+
      // R  Z  S  P  P  I  I  T  P  2  N  T  S   |
      // U  E  E  2  2  2  2  R  E  I  T  C  C   +- secondOp
      // N  X  X  U  S  F  F  N  X  N  2  V  V   |
      // C  T  T  I  I  P  P  C  T  T  P  T  T  -+
      new$char(13, 1, 0, 0, 99, 99, 0, 0, 99, 99, 99, 0, 3, 0),  // Trunc         -+
      new$char(13, 8, 1, 9, 99, 99, 2, 17, 99, 99, 99, 2, 3, 0),  // ZExt           |
      new$char(13, 8, 0, 1, 99, 99, 0, 2, 99, 99, 99, 0, 3, 0),  // SExt           |
      new$char(13, 0, 0, 0, 99, 99, 0, 0, 99, 99, 99, 0, 3, 0),  // FPToUI         |
      new$char(13, 0, 0, 0, 99, 99, 0, 0, 99, 99, 99, 0, 3, 0),  // FPToSI         |
      new$char(13, 99, 99, 99, 0, 0, 99, 99, 0, 0, 99, 99, 4, 0),  // UIToFP         +- firstOp
      new$char(13, 99, 99, 99, 0, 0, 99, 99, 0, 0, 99, 99, 4, 0),  // SIToFP         |
      new$char(13, 99, 99, 99, 0, 0, 99, 99, 0, 0, 99, 99, 4, 0),  // FPTrunc        |
      new$char(13, 99, 99, 99, 2, 2, 99, 99, 10, 2, 99, 99, 4, 0),  // FPExt          |
      new$char(13, 1, 0, 0, 99, 99, 0, 0, 99, 99, 99, 7, 3, 0),  // PtrToInt       |
      new$char(13, 99, 99, 99, 99, 99, 99, 99, 99, 99, 11, 99, 15, 0),  // IntToPtr       |
      new$char(13, 5, 5, 5, 6, 6, 5, 5, 6, 6, 16, 5, 1, 14),  // BitCast        |
      new$char(13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 13, 12) // AddrSpaceCast -+
    };
  }

  
  /// @brief Return the opcode of this CastInst
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::getOpcode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 826,
   FQN="llvm::CastInst::getOpcode", NM="_ZNK4llvm8CastInst9getOpcodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CastInst9getOpcodeEv")
  //</editor-fold>
  public /*CastOps*/int getOpcode() /*const*/ {
    return ((/*CastOps*/int)(super.getOpcode()));
  }

  
  /// @brief Return the source type, as a convenience
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::getSrcTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 831,
   FQN="llvm::CastInst::getSrcTy", NM="_ZNK4llvm8CastInst8getSrcTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CastInst8getSrcTyEv")
  //</editor-fold>
  public Type /*P*/ getSrcTy() /*const*/ {
    return getOperand(0).getType();
  }

  /// @brief Return the destination type, as a convenience
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::getDestTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 833,
   FQN="llvm::CastInst::getDestTy", NM="_ZNK4llvm8CastInst9getDestTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CastInst9getDestTyEv")
  //</editor-fold>
  public Type /*P*/ getDestTy() /*const*/ {
    return getType();
  }

  
  /// This method can be used to determine if a cast from S to DstTy using
  /// Opcode op is valid or not.
  /// @returns true iff the proposed cast is valid.
  /// @brief Determine if a cast is valid without creating one.
  
  //===----------------------------------------------------------------------===//
  //                    CastInst SubClass Constructors
  //===----------------------------------------------------------------------===//
  
  /// Check that the construction parameters for a CastInst are correct. This
  /// could be broken out into the separate constructors but it is useful to have
  /// it in one place and to eliminate the redundant code for getting the sizes
  /// of the types involved.
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::castIsValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3083,
   FQN="llvm::CastInst::castIsValid", NM="_ZN4llvm8CastInst11castIsValidENS_11Instruction7CastOpsEPNS_5ValueEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInst11castIsValidENS_11Instruction7CastOpsEPNS_5ValueEPNS_4TypeE")
  //</editor-fold>
  public static boolean castIsValid(/*CastOps*/int op, Value /*P*/ S, Type /*P*/ DstTy) {
    
    // Check for type sanity on the arguments
    Type /*P*/ SrcTy = S.getType();
    if (!SrcTy.isFirstClassType() || !DstTy.isFirstClassType()
       || SrcTy.isAggregateType() || DstTy.isAggregateType()) {
      return false;
    }
    
    // Get the size of the types in bits, we'll need this later
    /*uint*/int SrcBitSize = SrcTy.getScalarSizeInBits();
    /*uint*/int DstBitSize = DstTy.getScalarSizeInBits();
    
    // If these are vector types, get the lengths of the vectors (using zero for
    // scalar types means that checking that vector lengths match also checks that
    // scalars are not being converted to vectors or vectors to scalars).
    /*uint*/int SrcLength = SrcTy.isVectorTy() ? cast_VectorType(SrcTy).getNumElements() : 0;
    /*uint*/int DstLength = DstTy.isVectorTy() ? cast_VectorType(DstTy).getNumElements() : 0;
    
    // Switch on the opcode provided
    switch (op) {
     default:
      return false; // This is an input error
     case Instruction.CastOps.Trunc:
      return SrcTy.isIntOrIntVectorTy() && DstTy.isIntOrIntVectorTy()
         && SrcLength == DstLength && $greater_uint(SrcBitSize, DstBitSize);
     case Instruction.CastOps.ZExt:
      return SrcTy.isIntOrIntVectorTy() && DstTy.isIntOrIntVectorTy()
         && SrcLength == DstLength && $less_uint(SrcBitSize, DstBitSize);
     case Instruction.CastOps.SExt:
      return SrcTy.isIntOrIntVectorTy() && DstTy.isIntOrIntVectorTy()
         && SrcLength == DstLength && $less_uint(SrcBitSize, DstBitSize);
     case Instruction.CastOps.FPTrunc:
      return SrcTy.isFPOrFPVectorTy() && DstTy.isFPOrFPVectorTy()
         && SrcLength == DstLength && $greater_uint(SrcBitSize, DstBitSize);
     case Instruction.CastOps.FPExt:
      return SrcTy.isFPOrFPVectorTy() && DstTy.isFPOrFPVectorTy()
         && SrcLength == DstLength && $less_uint(SrcBitSize, DstBitSize);
     case Instruction.CastOps.UIToFP:
     case Instruction.CastOps.SIToFP:
      return SrcTy.isIntOrIntVectorTy() && DstTy.isFPOrFPVectorTy()
         && SrcLength == DstLength;
     case Instruction.CastOps.FPToUI:
     case Instruction.CastOps.FPToSI:
      return SrcTy.isFPOrFPVectorTy() && DstTy.isIntOrIntVectorTy()
         && SrcLength == DstLength;
     case Instruction.CastOps.PtrToInt:
      if (isa_VectorType(SrcTy) != isa_VectorType(DstTy)) {
        return false;
      }
      {
        VectorType /*P*/ VT = dyn_cast_VectorType(SrcTy);
        if ((VT != null)) {
          if (VT.getNumElements() != cast_VectorType(DstTy).getNumElements()) {
            return false;
          }
        }
      }
      return SrcTy.getScalarType().isPointerTy()
         && DstTy.getScalarType().isIntegerTy();
     case Instruction.CastOps.IntToPtr:
      if (isa_VectorType(SrcTy) != isa_VectorType(DstTy)) {
        return false;
      }
      {
        VectorType /*P*/ VT = dyn_cast_VectorType(SrcTy);
        if ((VT != null)) {
          if (VT.getNumElements() != cast_VectorType(DstTy).getNumElements()) {
            return false;
          }
        }
      }
      return SrcTy.getScalarType().isIntegerTy()
         && DstTy.getScalarType().isPointerTy();
     case Instruction.CastOps.BitCast:
      {
        PointerType /*P*/ SrcPtrTy = dyn_cast_PointerType(SrcTy.getScalarType());
        PointerType /*P*/ DstPtrTy = dyn_cast_PointerType(DstTy.getScalarType());
        
        // BitCast implies a no-op cast of type only. No bits change.
        // However, you can't cast pointers to anything but pointers.
        if (!(SrcPtrTy != null) != !(DstPtrTy != null)) {
          return false;
        }
        
        // For non-pointer cases, the cast is okay if the source and destination bit
        // widths are identical.
        if (!(SrcPtrTy != null)) {
          return SrcTy.getPrimitiveSizeInBits() == DstTy.getPrimitiveSizeInBits();
        }
        
        // If both are pointers then the address spaces must match.
        if (SrcPtrTy.getAddressSpace() != DstPtrTy.getAddressSpace()) {
          return false;
        }
        {
          
          // A vector of pointers must have the same number of elements.
          VectorType /*P*/ SrcVecTy = dyn_cast_VectorType(SrcTy);
          if ((SrcVecTy != null)) {
            {
              VectorType /*P*/ DstVecTy = dyn_cast_VectorType(DstTy);
              if ((DstVecTy != null)) {
                return (SrcVecTy.getNumElements() == DstVecTy.getNumElements());
              }
            }
            
            return false;
          }
        }
        
        return true;
      }
     case Instruction.CastOps.AddrSpaceCast:
      {
        PointerType /*P*/ SrcPtrTy = dyn_cast_PointerType(SrcTy.getScalarType());
        if (!(SrcPtrTy != null)) {
          return false;
        }
        
        PointerType /*P*/ DstPtrTy = dyn_cast_PointerType(DstTy.getScalarType());
        if (!(DstPtrTy != null)) {
          return false;
        }
        if (SrcPtrTy.getAddressSpace() == DstPtrTy.getAddressSpace()) {
          return false;
        }
        {
          
          VectorType /*P*/ SrcVecTy = dyn_cast_VectorType(SrcTy);
          if ((SrcVecTy != null)) {
            {
              VectorType /*P*/ DstVecTy = dyn_cast_VectorType(DstTy);
              if ((DstVecTy != null)) {
                return (SrcVecTy.getNumElements() == DstVecTy.getNumElements());
              }
            }
            
            return false;
          }
        }
        
        return true;
      }
    }
  }

  
  /// @brief Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 842,
   FQN="llvm::CastInst::classof", NM="_ZN4llvm8CastInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.isCast();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 845,
   FQN="llvm::CastInst::classof", NM="_ZN4llvm8CastInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && CastInst.classof(cast_Instruction(V));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CastInst::~CastInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 564,
   FQN="llvm::CastInst::~CastInst", NM="_ZN4llvm8CastInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CastInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
