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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.llvmc.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.ir.java.IRMemberPointers.*;
import org.llvm.ir.java.*;
import static org.llvm.ir.impl.CFGLlvmGlobals.*;
import org.llvm.ir.impl.SymbolTableListTraits$Instruction.SymbolTableList$Instruction;


/// \brief LLVM Basic Block Representation
///
/// This represents a single basic block in LLVM. A basic block is simply a
/// container of instructions that execute sequentially. Basic blocks are Values
/// because they are referenced by instructions such as branches and switch
/// tables. The type of a BasicBlock is "Type::LabelTy" because the basic block
/// represents a label to which a branch can jump.
///
/// A well formed basic block is formed of a list of non-terminating
/// instructions followed by a single TerminatorInst instruction.
/// TerminatorInst's may not occur in the middle of basic blocks, and must
/// terminate the blocks. The BasicBlock class allows malformed basic blocks to
/// occur because it may be useful in the intermediate stage of constructing or
/// modifying a program. However, the verifier will ensure that basic blocks
/// are "well formed".
//<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 52,
 FQN="llvm::BasicBlock", NM="_ZN4llvm10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlockE")
//</editor-fold>
public class BasicBlock extends /*public*/ Value implements /*public*/ ilist_node_with_parent<BasicBlock, Function>, IChild<Function>, IValueSymbolTableProvider, Iterable<Instruction>, Destructors.ClassWithDestructor, LLVMOpaqueBasicBlock {
  /*friend  class BlockAddress*/
/*public:*/
  // JAVA: typedef SymbolTableList<Instruction> InstListType
//  public final class InstListType extends SymbolTableList<Instruction, BasicBlock>{ };
/*private:*/
  private final SymbolTableList<Instruction, BasicBlock> InstList;
  private Function /*P*/ Parent;

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::setParent">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 88,
   FQN="llvm::BasicBlock::setParent", NM="_ZN4llvm10BasicBlock9setParentEPNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock9setParentEPNS_8FunctionE")
  //</editor-fold>
  public /*friend*//*private*/ void setParent(Function /*P*/ parent) {
    // Set Parent=parent, updating instruction symtab entries as appropriate.
    InstList.setSymTabObject(InstList, $AddrOf(
            new type$ptr$inout<Function/*P*/>(this) {
                @Override
                protected Function $star$impl() {
                  return Parent;
                }

                @Override
                protected Function $set$impl(Function value) {
                  return Parent = value;
                }
                
            }
    ), parent);
  }

  /*friend  class SymbolTableListTraits<BasicBlock>*/

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::BasicBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 65,
   FQN="llvm::BasicBlock::BasicBlock", NM="_ZN4llvm10BasicBlockC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlockC1ERKS0_")
  //</editor-fold>
  protected/*private*/ BasicBlock(final /*const*/ BasicBlock /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 66,
   FQN="llvm::BasicBlock::operator=", NM="_ZN4llvm10BasicBlockaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlockaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ BasicBlock /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}


  /// \brief Constructor.
  ///
  /// If the function parameter is specified, the basic block is automatically
  /// inserted at either the end of the function (if InsertBefore is null), or
  /// before the specified basic block.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::BasicBlock">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 41,
   FQN="llvm::BasicBlock::BasicBlock", NM="_ZN4llvm10BasicBlockC1ERNS_11LLVMContextERKNS_5TwineEPNS_8FunctionEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlockC1ERNS_11LLVMContextERKNS_5TwineEPNS_8FunctionEPS0_")
  //</editor-fold>
  private BasicBlock(final LLVMContext /*&*/ C) {
    this(C, new Twine(/*KEEP_STR*/$EMPTY), (Function /*P*/ )null,
      (BasicBlock /*P*/ )null);
  }
  private BasicBlock(final LLVMContext /*&*/ C, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    this(C, Name, (Function /*P*/ )null,
      (BasicBlock /*P*/ )null);
  }
  private BasicBlock(final LLVMContext /*&*/ C, final /*const*/ Twine /*&*/ Name/*= ""*/, Function /*P*/ NewParent/*= null*/) {
    this(C, Name, NewParent,
      (BasicBlock /*P*/ )null);
  }
  private BasicBlock(final LLVMContext /*&*/ C, final /*const*/ Twine /*&*/ Name/*= ""*/, Function /*P*/ NewParent/*= null*/,
      BasicBlock /*P*/ InsertBefore/*= null*/) {
    // : Value(Type::getLabelTy(C), Value::BasicBlockVal), ilist_node_with_parent<BasicBlock, Function>(), InstList(), Parent(null)
    //START JInit
    super(Type.getLabelTy(C), Value.ValueTy.BasicBlockVal.getValue());
    this.ilist_node$Flds = $ilist_node_with_parent();
    this.InstList = new SymbolTableList$Instruction(this);
    this.Parent = null;
    //END JInit
    if ((NewParent != null)) {
      insertInto(NewParent, InsertBefore);
    } else {
      assert (!(InsertBefore != null)) : "Cannot insert block before another block with no function!";
    }

    setName(Name);
  }

/*public:*/
  /// \brief Get the context in which this basic block lives.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 33,
   FQN="llvm::BasicBlock::getContext", NM="_ZNK4llvm10BasicBlock10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZNK4llvm10BasicBlock10getContextEv")
  //</editor-fold>
  public LLVMContext /*&*/ getContext() /*const*/ {
    return getType().getContext();
  }


  /// Instruction iterators...
  // JAVA: typedef InstListType::iterator iterator
//  public final class iterator extends ilist_iterator<Instruction>{ };
  // JAVA: typedef InstListType::const_iterator const_iterator
//  public final class const_iterator extends ilist_iterator</*const*/ Instruction>{ };
  // JAVA: typedef InstListType::reverse_iterator reverse_iterator
//  public final class reverse_iterator extends std.reverse_iterator<Instruction>{ };
  // JAVA: typedef InstListType::const_reverse_iterator const_reverse_iterator
//  public final class const_reverse_iterator extends std.reverse_iterator</*const*/ Instruction>{ };

  /// \brief Creates a new BasicBlock.
  ///
  /// If the Parent parameter is specified, the basic block is automatically
  /// inserted at either the end of the function (if InsertBefore is 0), or
  /// before the specified basic block.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 91,
   FQN="llvm::BasicBlock::Create", NM="_ZN4llvm10BasicBlock6CreateERNS_11LLVMContextERKNS_5TwineEPNS_8FunctionEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock6CreateERNS_11LLVMContextERKNS_5TwineEPNS_8FunctionEPS0_")
  //</editor-fold>
  public static BasicBlock /*P*/ Create(final LLVMContext /*&*/ Context) {
    return Create(Context, new Twine(/*KEEP_STR*/$EMPTY),
        (Function /*P*/ )null,
        (BasicBlock /*P*/ )null);
  }
  public static BasicBlock /*P*/ Create(final LLVMContext /*&*/ Context, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Create(Context, Name,
        (Function /*P*/ )null,
        (BasicBlock /*P*/ )null);
  }
  public static BasicBlock /*P*/ Create(final LLVMContext /*&*/ Context, final /*const*/ Twine /*&*/ Name/*= ""*/,
        Function /*P*/ Parent/*= null*/) {
    return Create(Context, Name,
        Parent,
        (BasicBlock /*P*/ )null);
  }
  public static BasicBlock /*P*/ Create(final LLVMContext /*&*/ Context, final /*const*/ Twine /*&*/ Name/*= ""*/,
        Function /*P*/ Parent/*= null*/,
        BasicBlock /*P*/ InsertBefore/*= null*/) {
    return new BasicBlock(Context, Name, Parent, InsertBefore);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::~BasicBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 64,
   FQN="llvm::BasicBlock::~BasicBlock", NM="_ZN4llvm10BasicBlockD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlockD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    // If the address of the block is taken and it is being deleted (e.g. because
    // it is dead), this means that there is either a dangling constant expr
    // hanging off the block, or an undefined use of the block (source code
    // expecting the address of a label to keep the block alive even though there
    // is no indirect branch).  Handle these cases by zapping the BlockAddress
    // nodes.  There are no other possible uses at this point.
    if (hasAddressTaken()) {
      assert (!use_empty()) : "There should be at least one blockaddress!";
      Constant /*P*/ Replacement = ConstantInt.get(Type.getInt32Ty(getContext()), $int2ulong(1));
      while (!use_empty()) {
        BlockAddress /*P*/ BA = cast_BlockAddress(user_back$Value());
        BA.replaceAllUsesWith(ConstantExpr.getIntToPtr(Replacement,
                BA.getType()));
        BA.destroyConstant();
      }
    }
    assert (getParent() == null) : "BasicBlock still linked into the program!";
    dropAllReferences();
    InstList.clear();
    //START JDestroy
    InstList.$destroy();
    super.$destroy();
    ilist_node_with_parent.super.$destroy$ilist_node_with_parent();
    //END JDestroy
  }


  /// \brief Return the enclosing method, or null if none.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 99,
   FQN="llvm::BasicBlock::getParent", NM="_ZNK4llvm10BasicBlock9getParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZNK4llvm10BasicBlock9getParentEv")
  //</editor-fold>
  public /*const*/ Function /*P*/ getParent$Const() /*const*/ {
    return Parent;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 100,
   FQN="llvm::BasicBlock::getParent", NM="_ZN4llvm10BasicBlock9getParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock9getParentEv")
  //</editor-fold>
  public Function /*P*/ getParent() {
    return Parent;
  }


  /// \brief Return the module owning the function this basic block belongs to,
  /// or nullptr it the function does not have a module.
  ///
  /// Note: this is undefined behavior if the block does not have a parent.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 116,
   FQN="llvm::BasicBlock::getModule", NM="_ZNK4llvm10BasicBlock9getModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZNK4llvm10BasicBlock9getModuleEv")
  //</editor-fold>
  public /*const*/ Module /*P*/ getModule$Const() /*const*/ {
    return getParent$Const().getParent$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 120,
   FQN="llvm::BasicBlock::getModule", NM="_ZN4llvm10BasicBlock9getModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock9getModuleEv")
  //</editor-fold>
  public Module /*P*/ getModule() {
    return getParent().getParent();
  }


  /// \brief Returns the terminator instruction if the block is well formed or
  /// null if the block is not well formed.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getTerminator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 124,
   FQN="llvm::BasicBlock::getTerminator", NM="_ZN4llvm10BasicBlock13getTerminatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock13getTerminatorEv")
  //</editor-fold>
  public TerminatorInst /*P*/ getTerminator() {
    if (InstList.empty()) {
      return null;
    }
    return dyn_cast_TerminatorInst($AddrOf(InstList.back()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getTerminator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 129,
   FQN="llvm::BasicBlock::getTerminator", NM="_ZNK4llvm10BasicBlock13getTerminatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZNK4llvm10BasicBlock13getTerminatorEv")
  //</editor-fold>
  public /*const*/ TerminatorInst /*P*/ getTerminator$Const() /*const*/ {
    if (InstList.empty()) {
      return null;
  }
    return dyn_cast_TerminatorInst($AddrOf(InstList.back$Const()));
  }


  /// \brief Returns the call instruction calling @llvm.experimental.deoptimize
  /// prior to the terminating return instruction of this basic block, if such a
  /// call is present.  Otherwise, returns null.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getTerminatingDeoptimizeCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 165,
   FQN="llvm::BasicBlock::getTerminatingDeoptimizeCall", NM="_ZN4llvm10BasicBlock28getTerminatingDeoptimizeCallEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock28getTerminatingDeoptimizeCallEv")
  //</editor-fold>
  public CallInst /*P*/ getTerminatingDeoptimizeCall() {
    if (InstList.empty()) {
      return null;
    }
    ReturnInst /*P*/ RI = dyn_cast_ReturnInst($AddrOf(InstList.back()));
    if (!(RI != null) || RI == $AddrOf(InstList.front())) {
      return null;
    }
    {

      CallInst /*P*/ CI = dyn_cast_or_null_CallInst(RI.getPrevNode());
      if ((CI != null)) {
        {
          Function /*P*/ F = CI.getCalledFunction();
          if ((F != null)) {
            if (F.getIntrinsicID() == ID.experimental_deoptimize) {
              return CI;
            }
          }
        }
      }
    }

    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getTerminatingDeoptimizeCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 118,
   FQN="llvm::BasicBlock::getTerminatingDeoptimizeCall", NM="_ZNK4llvm10BasicBlock28getTerminatingDeoptimizeCallEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZNK4llvm10BasicBlock28getTerminatingDeoptimizeCallEv")
  //</editor-fold>
  public /*const*/ CallInst /*P*/ getTerminatingDeoptimizeCall$Const() /*const*/ {
    return ((/*const_cast*/BasicBlock /*P*/ )(this)).getTerminatingDeoptimizeCall();
  }


  /// \brief Returns the call instruction marked 'musttail' prior to the
  /// terminating return instruction of this basic block, if such a call is
  /// present.  Otherwise, returns null.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getTerminatingMustTailCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 134,
   FQN="llvm::BasicBlock::getTerminatingMustTailCall", NM="_ZN4llvm10BasicBlock26getTerminatingMustTailCallEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock26getTerminatingMustTailCallEv")
  //</editor-fold>
  public CallInst /*P*/ getTerminatingMustTailCall() {
    if (InstList.empty()) {
      return null;
    }
    ReturnInst /*P*/ RI = dyn_cast_ReturnInst($AddrOf(InstList.back()));
    if (!(RI != null) || RI == $AddrOf(InstList.front())) {
      return null;
    }

    Instruction /*P*/ Prev = RI.getPrevNode();
    if (!(Prev != null)) {
      return null;
    }
    {

      Value /*P*/ RV = RI.getReturnValue();
      if ((RV != null)) {
        if (RV != Prev) {
          return null;
        }
        {

          // Look through the optional bitcast.
          BitCastInst /*P*/ BI = dyn_cast_BitCastInst(Prev);
          if ((BI != null)) {
            RV = BI.getOperand(0);
            Prev = BI.getPrevNode();
            if (!(Prev != null) || RV != Prev) {
              return null;
            }
          }
        }
      }
    }
    {

      CallInst /*P*/ CI = dyn_cast_CallInst(Prev);
      if ((CI != null)) {
        if (CI.isMustTailCall()) {
          return CI;
        }
      }
    }
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getTerminatingMustTailCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 126,
   FQN="llvm::BasicBlock::getTerminatingMustTailCall", NM="_ZNK4llvm10BasicBlock26getTerminatingMustTailCallEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZNK4llvm10BasicBlock26getTerminatingMustTailCallEv")
  //</editor-fold>
  public /*const*/ CallInst /*P*/ getTerminatingMustTailCall$Const() /*const*/ {
    return ((/*const_cast*/BasicBlock /*P*/ )(this)).getTerminatingMustTailCall();
  }


  /// \brief Returns a pointer to the first instruction in this block that is
  /// not a PHINode instruction.
  ///
  /// When adding instructions to the beginning of the basic block, they should
  /// be added before the returned value, not before the first instruction,
  /// which might be PHI. Returns 0 is there's no non-PHI instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getFirstNonPHI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 180,
   FQN="llvm::BasicBlock::getFirstNonPHI", NM="_ZN4llvm10BasicBlock14getFirstNonPHIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock14getFirstNonPHIEv")
  //</editor-fold>
  public Instruction /*P*/ getFirstNonPHI() {
    for (final Instruction /*&*/ I : /*Deref*/this)  {
      if (!isa_PHINode(I)) {
        return $AddrOf(I);
      }
    }
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getFirstNonPHI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 137,
   FQN="llvm::BasicBlock::getFirstNonPHI", NM="_ZNK4llvm10BasicBlock14getFirstNonPHIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZNK4llvm10BasicBlock14getFirstNonPHIEv")
  //</editor-fold>
  public /*const*/ Instruction /*P*/ getFirstNonPHI$Const() /*const*/ {
    return ((/*const_cast*/BasicBlock /*P*/ )(this)).getFirstNonPHI();
  }


  /// \brief Returns a pointer to the first instruction in this block that is not
  /// a PHINode or a debug intrinsic.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getFirstNonPHIOrDbg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 187,
   FQN="llvm::BasicBlock::getFirstNonPHIOrDbg", NM="_ZN4llvm10BasicBlock19getFirstNonPHIOrDbgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock19getFirstNonPHIOrDbgEv")
  //</editor-fold>
  public Instruction /*P*/ getFirstNonPHIOrDbg() {
    for (final Instruction /*&*/ I : /*Deref*/this)  {
      if (!isa_PHINode(I) && !isa_DbgInfoIntrinsic(I)) {
        return $AddrOf(I);
      }
    }
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getFirstNonPHIOrDbg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 144,
   FQN="llvm::BasicBlock::getFirstNonPHIOrDbg", NM="_ZNK4llvm10BasicBlock19getFirstNonPHIOrDbgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZNK4llvm10BasicBlock19getFirstNonPHIOrDbgEv")
  //</editor-fold>
  public /*const*/ Instruction /*P*/ getFirstNonPHIOrDbg$Const() /*const*/ {
    return ((/*const_cast*/BasicBlock /*P*/ )(this)).getFirstNonPHIOrDbg();
  }


  /// \brief Returns a pointer to the first instruction in this block that is not
  /// a PHINode, a debug intrinsic, or a lifetime intrinsic.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getFirstNonPHIOrDbgOrLifetime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 194,
   FQN="llvm::BasicBlock::getFirstNonPHIOrDbgOrLifetime", NM="_ZN4llvm10BasicBlock29getFirstNonPHIOrDbgOrLifetimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock29getFirstNonPHIOrDbgOrLifetimeEv")
  //</editor-fold>
  public Instruction /*P*/ getFirstNonPHIOrDbgOrLifetime() {
    for (final Instruction /*&*/ I : /*Deref*/this) {
      if (isa_PHINode(I) || isa_DbgInfoIntrinsic(I)) {
        continue;
      }
      {

        IntrinsicInst /*P*/ II = dyn_cast_IntrinsicInst($AddrOf(I));
        if ((II != null)) {
          if (II.getIntrinsicID() == ID.lifetime_start
             || II.getIntrinsicID() == ID.lifetime_end) {
            continue;
          }
        }
      }

      return $AddrOf(I);
    }
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getFirstNonPHIOrDbgOrLifetime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 151,
   FQN="llvm::BasicBlock::getFirstNonPHIOrDbgOrLifetime", NM="_ZNK4llvm10BasicBlock29getFirstNonPHIOrDbgOrLifetimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZNK4llvm10BasicBlock29getFirstNonPHIOrDbgOrLifetimeEv")
  //</editor-fold>
  public /*const*/ Instruction /*P*/ getFirstNonPHIOrDbgOrLifetime$Const() /*const*/ {
    return ((/*const_cast*/BasicBlock /*P*/ )(this)).getFirstNonPHIOrDbgOrLifetime();
  }


  /// \brief Returns an iterator to the first instruction in this block that is
  /// suitable for inserting a non-PHI instruction.
  ///
  /// In particular, it skips all PHIs and LandingPad instructions.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getFirstInsertionPt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 209,
   FQN="llvm::BasicBlock::getFirstInsertionPt", NM="_ZN4llvm10BasicBlock19getFirstInsertionPtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock19getFirstInsertionPtEv")
  //</editor-fold>
  public ilist_iterator<Instruction> getFirstInsertionPt() {
    Instruction /*P*/ FirstNonPHI = getFirstNonPHI();
    if (!(FirstNonPHI != null)) {
      return end();
    }

    ilist_iterator<Instruction> InsertPt = FirstNonPHI.getIterator();
    if (InsertPt.$arrow().isEHPad()) {
      InsertPt.$preInc();
    }
    return InsertPt;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getFirstInsertionPt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 160,
   FQN="llvm::BasicBlock::getFirstInsertionPt", NM="_ZNK4llvm10BasicBlock19getFirstInsertionPtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZNK4llvm10BasicBlock19getFirstInsertionPtEv")
  //</editor-fold>
  public ilist_iterator</*const*/ Instruction> getFirstInsertionPt$Const() /*const*/ {
    return new ilist_iterator</*const*/ Instruction>(((/*const_cast*/BasicBlock /*P*/ )(this)).getFirstInsertionPt());
  }


  /// \brief Unlink 'this' from the containing function, but do not delete it.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::removeFromParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 93,
   FQN="llvm::BasicBlock::removeFromParent", NM="_ZN4llvm10BasicBlock16removeFromParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock16removeFromParentEv")
  //</editor-fold>
  public void removeFromParent() {
    getParent().getBasicBlockList().remove_ilist_iterator$NodeTy$C(getIterator());
  }


  /// \brief Unlink 'this' from the containing function and delete it.
  ///
  // \returns an iterator pointing to the element after the erased one.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::eraseFromParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 97,
   FQN="llvm::BasicBlock::eraseFromParent", NM="_ZN4llvm10BasicBlock15eraseFromParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock15eraseFromParentEv")
  //</editor-fold>
  public ilist_iterator<BasicBlock> eraseFromParent() {
    return getParent().getBasicBlockList().erase(getIterator());
  }


  /// \brief Unlink this basic block from its current function and insert it
  /// into the function that \p MovePos lives in, right before \p MovePos.

  /// Unlink this basic block from its current function and
  /// insert it into the function that MovePos lives in, right before MovePos.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::moveBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 103,
   FQN="llvm::BasicBlock::moveBefore", NM="_ZN4llvm10BasicBlock10moveBeforeEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock10moveBeforeEPS0_")
  //</editor-fold>
  public void moveBefore(BasicBlock /*P*/ MovePos) {
    MovePos.getParent().getBasicBlockList().splice(MovePos.getIterator(), getParent().getBasicBlockList(), getIterator());
  }


  /// \brief Unlink this basic block from its current function and insert it
  /// right after \p MovePos in the function \p MovePos lives in.

  /// Unlink this basic block from its current function and
  /// insert it into the function that MovePos lives in, right after MovePos.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::moveAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 110,
   FQN="llvm::BasicBlock::moveAfter", NM="_ZN4llvm10BasicBlock9moveAfterEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock9moveAfterEPS0_")
  //</editor-fold>
  public void moveAfter(BasicBlock /*P*/ MovePos) {
    MovePos.getParent().getBasicBlockList().splice(new ilist_iterator<BasicBlock>(MovePos.getIterator().$preInc()), getParent().getBasicBlockList(),
        getIterator());
  }


  /// \brief Insert unlinked basic block into a function.
  ///
  /// Inserts an unlinked basic block into \c Parent.  If \c InsertBefore is
  /// provided, inserts before that basic block, otherwise inserts at the end.
  ///
  /// \pre \a getParent() is \c nullptr.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::insertInto">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 54,
   FQN="llvm::BasicBlock::insertInto", NM="_ZN4llvm10BasicBlock10insertIntoEPNS_8FunctionEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock10insertIntoEPNS_8FunctionEPS0_")
  //</editor-fold>
  public void insertInto(Function /*P*/ NewParent) {
    insertInto(NewParent, (BasicBlock /*P*/ )null);
  }
  public void insertInto(Function /*P*/ NewParent, BasicBlock /*P*/ InsertBefore/*= null*/) {
    assert ((NewParent != null)) : "Expected a parent";
    assert (!(Parent != null)) : "Already has a parent";
    if ((InsertBefore != null)) {
      NewParent.getBasicBlockList().insert_ilist_iterator$NodeTy_T$P(InsertBefore.getIterator(), this);
    } else {
      NewParent.getBasicBlockList().push_back(this);
    }
  }


  /// \brief Return the predecessor of this block if it has a single predecessor
  /// block. Otherwise return a null pointer.

  /// If this basic block has a single predecessor block,
  /// return the block, otherwise return a null pointer.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getSinglePredecessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 226,
   FQN="llvm::BasicBlock::getSinglePredecessor", NM="_ZN4llvm10BasicBlock20getSinglePredecessorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock20getSinglePredecessorEv")
  //</editor-fold>
  public BasicBlock /*P*/ getSinglePredecessor() {
    PredIterator<BasicBlock, Value.user_iterator_impl<User> > PI = pred_begin_BasicBlock$P(this);
    PredIterator<BasicBlock, Value.user_iterator_impl<User> > E = pred_end_BasicBlock$P(this);
    if (PI.$eq(E)) {
      return null; // No preds.
    }
    BasicBlock /*P*/ ThePred = PI.$star();
    PI.$preInc();
    return (PI.$eq(E)) ? ThePred : null/*multiple preds*/;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getSinglePredecessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 191,
   FQN="llvm::BasicBlock::getSinglePredecessor", NM="_ZNK4llvm10BasicBlock20getSinglePredecessorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZNK4llvm10BasicBlock20getSinglePredecessorEv")
  //</editor-fold>
  public /*const*/ BasicBlock /*P*/ getSinglePredecessor$Const() /*const*/ {
    return ((/*const_cast*/BasicBlock /*P*/ )(this)).getSinglePredecessor();
  }


  /// \brief Return the predecessor of this block if it has a unique predecessor
  /// block. Otherwise return a null pointer.
  ///
  /// Note that unique predecessor doesn't mean single edge, there can be
  /// multiple edges from the unique predecessor to this block (for example a
  /// switch statement with multiple cases having the same destination).

  /// If this basic block has a unique predecessor block,
  /// return the block, otherwise return a null pointer.
  /// Note that unique predecessor doesn't mean single edge, there can be
  /// multiple edges from the unique predecessor to this block (for example
  /// a switch statement with multiple cases having the same destination).
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getUniquePredecessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 239,
   FQN="llvm::BasicBlock::getUniquePredecessor", NM="_ZN4llvm10BasicBlock20getUniquePredecessorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock20getUniquePredecessorEv")
  //</editor-fold>
  public BasicBlock /*P*/ getUniquePredecessor() {
    PredIterator<BasicBlock, Value.user_iterator_impl<User> > PI = pred_begin_BasicBlock$P(this);
    PredIterator<BasicBlock, Value.user_iterator_impl<User> > E = pred_end_BasicBlock$P(this);
    if (PI.$eq(E)) {
      return null; // No preds.
    }
    BasicBlock /*P*/ PredBB = PI.$star();
    PI.$preInc();
    for (; PI.$noteq(E); PI.$preInc()) {
      if (PI.$star() != PredBB) {
        return null;
      }
      // The same predecessor appears multiple times in the predecessor list.
      // This is OK.
    }
    return PredBB;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getUniquePredecessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 202,
   FQN="llvm::BasicBlock::getUniquePredecessor", NM="_ZNK4llvm10BasicBlock20getUniquePredecessorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZNK4llvm10BasicBlock20getUniquePredecessorEv")
  //</editor-fold>
  public /*const*/ BasicBlock /*P*/ getUniquePredecessor$Const() /*const*/ {
    return ((/*const_cast*/BasicBlock /*P*/ )(this)).getUniquePredecessor();
  }


  /// \brief Return the successor of this block if it has a single successor.
  /// Otherwise return a null pointer.
  ///
  /// This method is analogous to getSinglePredecessor above.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getSingleSuccessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 253,
   FQN="llvm::BasicBlock::getSingleSuccessor", NM="_ZN4llvm10BasicBlock18getSingleSuccessorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock18getSingleSuccessorEv")
  //</editor-fold>
  public BasicBlock /*P*/ getSingleSuccessor() {
    TerminatorInst.SuccIterator<TerminatorInst /*P*/ , BasicBlock> SI = succ_begin_BasicBlock$P(this);
    TerminatorInst.SuccIterator<TerminatorInst /*P*/ , BasicBlock> E = succ_end_BasicBlock$P(this);
    if (SI.$eq(E)) {
      return null; // no successors
    }
    BasicBlock /*P*/ TheSucc = SI.$star();
    SI.$preInc();
    return (SI.$eq(E)) ? TheSucc : null/* multiple successors */;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getSingleSuccessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 211,
   FQN="llvm::BasicBlock::getSingleSuccessor", NM="_ZNK4llvm10BasicBlock18getSingleSuccessorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZNK4llvm10BasicBlock18getSingleSuccessorEv")
  //</editor-fold>
  public /*const*/ BasicBlock /*P*/ getSingleSuccessor$Const() /*const*/ {
    return ((/*const_cast*/BasicBlock /*P*/ )(this)).getSingleSuccessor();
  }


  /// \brief Return the successor of this block if it has a unique successor.
  /// Otherwise return a null pointer.
  ///
  /// This method is analogous to getUniquePredecessor above.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getUniqueSuccessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 261,
   FQN="llvm::BasicBlock::getUniqueSuccessor", NM="_ZN4llvm10BasicBlock18getUniqueSuccessorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock18getUniqueSuccessorEv")
  //</editor-fold>
  public BasicBlock /*P*/ getUniqueSuccessor() {
    TerminatorInst.SuccIterator<TerminatorInst /*P*/ , BasicBlock> SI = succ_begin_BasicBlock$P(this);
    TerminatorInst.SuccIterator<TerminatorInst /*P*/ , BasicBlock> E = succ_end_BasicBlock$P(this);
    if (SI.$eq(E)) {
      return null; // No successors
    }
    BasicBlock /*P*/ SuccBB = SI.$star();
    SI.$preInc();
    for (; SI.$noteq(E); SI.$preInc()) {
      if (SI.$star() != SuccBB) {
        return null;
      }
      // The same successor appears multiple times in the successor list.
      // This is OK.
    }
    return SuccBB;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getUniqueSuccessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 220,
   FQN="llvm::BasicBlock::getUniqueSuccessor", NM="_ZNK4llvm10BasicBlock18getUniqueSuccessorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZNK4llvm10BasicBlock18getUniqueSuccessorEv")
  //</editor-fold>
  public /*const*/ BasicBlock /*P*/ getUniqueSuccessor$Const() /*const*/ {
    return ((/*const_cast*/BasicBlock /*P*/ )(this)).getUniqueSuccessor();
  }


  //===--------------------------------------------------------------------===//
  /// Instruction iterator methods
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 227,
   FQN="llvm::BasicBlock::begin", NM="_ZN4llvm10BasicBlock5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock5beginEv")
  //</editor-fold>
  public /*inline*/ ilist_iterator<Instruction> begin() {
    return InstList.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 228,
   FQN="llvm::BasicBlock::begin", NM="_ZNK4llvm10BasicBlock5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZNK4llvm10BasicBlock5beginEv")
  //</editor-fold>
  public /*inline*/ ilist_iterator</*const*/ Instruction> begin$Const() /*const*/ {
    return InstList.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 229,
   FQN="llvm::BasicBlock::end", NM="_ZN4llvm10BasicBlock3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock3endEv")
  //</editor-fold>
  public /*inline*/ ilist_iterator<Instruction> end() {
    return InstList.end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 230,
   FQN="llvm::BasicBlock::end", NM="_ZNK4llvm10BasicBlock3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZNK4llvm10BasicBlock3endEv")
  //</editor-fold>
  public /*inline*/ ilist_iterator</*const*/ Instruction> end$Const() /*const*/ {
    return InstList.end$Const();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 232,
   FQN="llvm::BasicBlock::rbegin", NM="_ZN4llvm10BasicBlock6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock6rbeginEv")
  //</editor-fold>
  public /*inline*/ std.reverse_iterator<Instruction> rbegin() {
    return InstList.rbegin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 233,
   FQN="llvm::BasicBlock::rbegin", NM="_ZNK4llvm10BasicBlock6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZNK4llvm10BasicBlock6rbeginEv")
  //</editor-fold>
  public /*inline*/ std.reverse_iterator</*const*/ Instruction> rbegin$Const() /*const*/ {
    return InstList.rbegin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 234,
   FQN="llvm::BasicBlock::rend", NM="_ZN4llvm10BasicBlock4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock4rendEv")
  //</editor-fold>
  public /*inline*/ std.reverse_iterator<Instruction> rend() {
    return InstList.rend();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 235,
   FQN="llvm::BasicBlock::rend", NM="_ZNK4llvm10BasicBlock4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZNK4llvm10BasicBlock4rendEv")
  //</editor-fold>
  public /*inline*/ std.reverse_iterator</*const*/ Instruction> rend$Const() /*const*/ {
    return InstList.rend$Const();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 237,
   FQN="llvm::BasicBlock::size", NM="_ZNK4llvm10BasicBlock4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZNK4llvm10BasicBlock4sizeEv")
  //</editor-fold>
  public /*inline*/ /*size_t*/int size() /*const*/ {
    return InstList.size();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 238,
   FQN="llvm::BasicBlock::empty", NM="_ZNK4llvm10BasicBlock5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZNK4llvm10BasicBlock5emptyEv")
  //</editor-fold>
  public /*inline*/ boolean empty() /*const*/ {
    return InstList.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::front">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 239,
   FQN="llvm::BasicBlock::front", NM="_ZNK4llvm10BasicBlock5frontEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZNK4llvm10BasicBlock5frontEv")
  //</editor-fold>
  public /*inline*/ /*const*/ Instruction /*&*/ front$Const() /*const*/ {
    return InstList.front$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::front">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 240,
   FQN="llvm::BasicBlock::front", NM="_ZN4llvm10BasicBlock5frontEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock5frontEv")
  //</editor-fold>
  public /*inline*/ Instruction /*&*/ front() {
    return InstList.front();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::back">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 241,
   FQN="llvm::BasicBlock::back", NM="_ZNK4llvm10BasicBlock4backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZNK4llvm10BasicBlock4backEv")
  //</editor-fold>
  public /*inline*/ /*const*/ Instruction /*&*/ back$Const() /*const*/ {
    return InstList.back$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::back">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 242,
   FQN="llvm::BasicBlock::back", NM="_ZN4llvm10BasicBlock4backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock4backEv")
  //</editor-fold>
  public /*inline*/ Instruction /*&*/ back() {
    return InstList.back();
  }


  /// \brief Return the underlying instruction list container.
  ///
  /// Currently you need to access the underlying instruction list container
  /// directly if you want to modify it.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getInstList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 248,
   FQN="llvm::BasicBlock::getInstList", NM="_ZNK4llvm10BasicBlock11getInstListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZNK4llvm10BasicBlock11getInstListEv")
  //</editor-fold>
  public /*friend*//*public*/ /*const*/SymbolTableList<Instruction, BasicBlock>/*&*/ getInstList$Const() /*const*/ {
    return InstList;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getInstList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 249,
   FQN="llvm::BasicBlock::getInstList", NM="_ZN4llvm10BasicBlock11getInstListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock11getInstListEv")
  //</editor-fold>
  public /*friend*//*public*/ SymbolTableList<Instruction, BasicBlock>/*&*/ getInstList() {
    return InstList;
  }


  /// \brief Returns a pointer to a member of the instruction list.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getSublistAccess">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 252,
   FQN="llvm::BasicBlock::getSublistAccess", NM="_ZN4llvm10BasicBlock16getSublistAccessEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock16getSublistAccessEPNS_11InstructionE")
  //</editor-fold>
  public static Void2SymbolTableList<Instruction, BasicBlock> getSublistAccess(Instruction /*P*/ $Prm0) {
    return (BasicBlock $this) -> $this.InstList;
  }


  /// \brief Returns a pointer to the symbol table if one exists.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getValueSymbolTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 27,
   FQN="llvm::BasicBlock::getValueSymbolTable", NM="_ZN4llvm10BasicBlock19getValueSymbolTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock19getValueSymbolTableEv")
  //</editor-fold>
  public ValueSymbolTable /*P*/ getValueSymbolTable() {
    {
      Function /*P*/ F = getParent();
      if ((F != null)) {
        return $AddrOf(F.getValueSymbolTable());
      }
    }
    return null;
  }


  /// \brief Methods for support type inquiry through isa, cast, and dyn_cast.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 260,
   FQN="llvm::BasicBlock::classof", NM="_ZN4llvm10BasicBlock7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return V.getValueID() == Value.ValueTy.BasicBlockVal.getValue();
  }


  /// \brief Cause all subinstructions to "let go" of all the references that
  /// said subinstructions are maintaining.
  ///
  /// This allows one to 'delete' a whole class at a time, even though there may
  /// be circular references... first all references are dropped, and all use
  /// counts go to zero.  Then everything is delete'd for real.  Note that no
  /// operations are valid on an object that has "dropped all references",
  /// except operator delete.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::dropAllReferences">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 219,
   FQN="llvm::BasicBlock::dropAllReferences", NM="_ZN4llvm10BasicBlock17dropAllReferencesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock17dropAllReferencesEv")
  //</editor-fold>
  public void dropAllReferences() {
    for (final Instruction /*&*/ I : /*Deref*/this)  {
      I.dropAllReferences();
    }
  }


  /// \brief Notify the BasicBlock that the predecessor \p Pred is no longer
  /// able to reach it.
  ///
  /// This is actually not used to update the Predecessor list, but is actually
  /// used to update the PHI nodes that reside in the block.  Note that this
  /// should be called while the predecessor still refers to this block.

  /// This method is used to notify a BasicBlock that the
  /// specified Predecessor of the block is no longer able to reach it.  This is
  /// actually not used to update the Predecessor list, but is actually used to
  /// update the PHI nodes that reside in the block.  Note that this should be
  /// called while the predecessor still refers to this block.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::removePredecessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 281,
   FQN="llvm::BasicBlock::removePredecessor", NM="_ZN4llvm10BasicBlock17removePredecessorEPS0_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock17removePredecessorEPS0_b")
  //</editor-fold>
  public void removePredecessor(BasicBlock /*P*/ Pred) {
    removePredecessor(Pred,
                   false);
  }
  public void removePredecessor(BasicBlock /*P*/ Pred,
                   boolean DontDeleteUselessPHIs/*= false*/) {
    assert ((hasNUsesOrMore(16) || find(pred_begin_BasicBlock$P(this), pred_end_BasicBlock$P(this), Pred).$noteq(pred_end_BasicBlock$P(this)))) : "removePredecessor: BB is not a predecessor!";
    if (InstList.empty()) {
      return;
    }
    PHINode /*P*/ APN = dyn_cast_PHINode($AddrOf(front()));
    if (!(APN != null)) {
      return; // Quick exit.
    }

    // If there are exactly two predecessors, then we want to nuke the PHI nodes
    // altogether.  However, we cannot do this, if this in this case:
    //
    //  Loop:
    //    %x = phi [X, Loop]
    //    %x2 = add %x, 1         ;; This would become %x2 = add %x2, 1
    //    br Loop                 ;; %x2 does not dominate all uses
    //
    // This is because the PHI node input is actually taken from the predecessor
    // basic block.  The only case this can happen is with a self loop, so we
    // check for this case explicitly now.
    //
    /*uint*/int max_idx = APN.getNumIncomingValues();
    assert (max_idx != 0) : "PHI Node in block with 0 predecessors!?!?!";
    if (max_idx == 2) {
      BasicBlock /*P*/ Other = APN.getIncomingBlock(((APN.getIncomingBlock(0) == Pred) ? 1 : 0));

      // Disable PHI elimination!
      if (this == Other) {
        max_idx = 3;
      }
    }

    // <= Two predecessors BEFORE I remove one?
    if ($lesseq_uint(max_idx, 2) && !DontDeleteUselessPHIs) {
      {
        // Yup, loop through and nuke the PHI nodes
        PHINode /*P*/ PN;
        while (((/*P*/ PN = dyn_cast_PHINode($AddrOf(front()))) != null)) {
          // Remove the predecessor first.
          PN.removeIncomingValue(Pred, !DontDeleteUselessPHIs);

          // If the PHI _HAD_ two uses, replace PHI node with its now *single* value
          if (max_idx == 2) {
            if (PN.getIncomingValue(0) != PN) {
              PN.replaceAllUsesWith(PN.getIncomingValue(0));
            } else {
              // We are left with an infinite loop with no entries: kill the PHI.
              PN.replaceAllUsesWith(UndefValue.get(PN.getType()));
            }
            getInstList().pop_front(); // Remove the PHI node
          }
          // If the PHI node already only had one entry, it got deleted by
          // removeIncomingValue.
        }
      }
    } else {
      // Okay, now we know that we need to remove predecessor #pred_idx from all
      // PHI nodes.  Iterate over each PHI node fixing them up
      PHINode /*P*/ PN;
      for (ilist_iterator<Instruction> II = begin(); ((PN = dyn_cast_PHINode(II.$star())) != null);) {
        II.$preInc();
        PN.removeIncomingValue(Pred, false);
        // If all incoming values to the Phi are the same, we can replace the Phi
        // with that value.
        Value /*P*/ PNV = null;
        if (!DontDeleteUselessPHIs && ((PNV = PN.hasConstantValue()) != null)) {
          if (PNV != PN) {
            PN.replaceAllUsesWith(PNV);
            PN.eraseFromParent();
          }
        }
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::canSplitPredecessors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 351,
   FQN="llvm::BasicBlock::canSplitPredecessors", NM="_ZNK4llvm10BasicBlock20canSplitPredecessorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZNK4llvm10BasicBlock20canSplitPredecessorsEv")
  //</editor-fold>
  public boolean canSplitPredecessors() /*const*/ {
    /*const*/ Instruction /*P*/ FirstNonPHI = getFirstNonPHI$Const();
    if (isa_LandingPadInst(FirstNonPHI)) {
      return true;
    }
    // This is perhaps a little conservative because constructs like
    // CleanupBlockInst are pretty easy to split.  However, SplitBlockPredecessors
    // cannot handle such things just yet.
    if (FirstNonPHI.isEHPad()) {
      return false;
    }
    return true;
  }


  /// \brief Split the basic block into two basic blocks at the specified
  /// instruction.
  ///
  /// Note that all instructions BEFORE the specified iterator stay as part of
  /// the original basic block, an unconditional branch is added to the original
  /// BB, and the rest of the instructions in the BB are moved to the new BB,
  /// including the old terminator.  The newly formed BasicBlock is returned.
  /// This function invalidates the specified iterator.
  ///
  /// Note that this only works on well formed basic blocks (must have a
  /// terminator), and 'I' must not be the end of instruction list (which would
  /// cause a degenerate basic block to be formed, having a terminator inside of
  /// the basic block).
  ///
  /// Also note that this doesn't preserve any passes. To split blocks while
  /// keeping loop information consistent, use the SplitBlock utility function.

  /// This splits a basic block into two at the specified
  /// instruction.  Note that all instructions BEFORE the specified iterator stay
  /// as part of the original basic block, an unconditional branch is added to
  /// the new BB, and the rest of the instructions in the BB are moved to the new
  /// BB, including the old terminator.  This invalidates the iterator.
  ///
  /// Note that this only works on well formed basic blocks (must have a
  /// terminator), and 'I' must not be the end of instruction list (which would
  /// cause a degenerate basic block to be formed, having a terminator inside of
  /// the basic block).
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::splitBasicBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 374,
   FQN="llvm::BasicBlock::splitBasicBlock", NM="_ZN4llvm10BasicBlock15splitBasicBlockENS_14ilist_iteratorINS_11InstructionEEERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock15splitBasicBlockENS_14ilist_iteratorINS_11InstructionEEERKNS_5TwineE")
  //</editor-fold>
  public BasicBlock /*P*/ splitBasicBlock(ilist_iterator<Instruction> I) {
    return splitBasicBlock(I, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public BasicBlock /*P*/ splitBasicBlock(ilist_iterator<Instruction> I, final /*const*/ Twine /*&*/ BBName/*= ""*/) {
    DebugLoc Loc = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert ((getTerminator() != null)) : "Can't use splitBasicBlock on degenerate BB!";
      assert (I.$noteq(InstList.end())) : "Trying to get me to create degenerate basic block!";

      BasicBlock /*P*/ New = BasicBlock.Create(getContext(), BBName, getParent(),
          /*J:ToBase*/ilist_node_with_parent /*P*/ .super.getNextNode());

      // Save DebugLoc of split point before invalidating iterator.
      Loc = new DebugLoc(I.$arrow().getDebugLoc());
      // Move all of the specified instructions from the original basic block into
      // the new basic block.
      New.getInstList().splice(New.end(), this.getInstList(), new ilist_iterator<Instruction>(I), end());

      // Add a branch instruction to the newly formed basic block.
      BranchInst /*P*/ BI = BranchInst.Create(New, this);
      BI.setDebugLoc($c$.track(new DebugLoc(Loc))); $c$.clean();

      // Now we must loop through all of the successors of the New block (which
      // _were_ the successors of the 'this' block), and update any PHI nodes in
      // successors.  If there were PHI nodes in the successors, then they need to
      // know that incoming branches will be from New, not from Old.
      //
      for (TerminatorInst.SuccIterator<TerminatorInst /*P*/ , BasicBlock> I$1 = succ_begin_BasicBlock$P(New), E = succ_end_BasicBlock$P(New); I$1.$noteq(E); I$1.$preInc()) {
        // Loop over any phi nodes in the basic block, updating the BB field of
        // incoming values...
        BasicBlock /*P*/ Successor = I$1.$star();
        PHINode /*P*/ PN;
        for (ilist_iterator<Instruction> II = Successor.begin();
             ((PN = dyn_cast_PHINode(II.$star())) != null); II.$preInc()) {
          int IDX = PN.getBasicBlockIndex(this);
          while (IDX != -1) {
            PN.setIncomingBlock((/*uint*/int)IDX, New);
            IDX = PN.getBasicBlockIndex(this);
          }
        }
      }
      return New;
    } finally {
      if (Loc != null) { Loc.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::splitBasicBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 301,
   FQN="llvm::BasicBlock::splitBasicBlock", NM="_ZN4llvm10BasicBlock15splitBasicBlockEPNS_11InstructionERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock15splitBasicBlockEPNS_11InstructionERKNS_5TwineE")
  //</editor-fold>
  public BasicBlock /*P*/ splitBasicBlock(Instruction /*P*/ I) {
    return splitBasicBlock(I, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public BasicBlock /*P*/ splitBasicBlock(Instruction /*P*/ I, final /*const*/ Twine /*&*/ BBName/*= ""*/) {
    return splitBasicBlock(I.getIterator(), BBName);
  }


  /// \brief Returns true if there are any uses of this basic block other than
  /// direct branches, switches, etc. to it.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::hasAddressTaken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 307,
   FQN="llvm::BasicBlock::hasAddressTaken", NM="_ZNK4llvm10BasicBlock15hasAddressTakenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZNK4llvm10BasicBlock15hasAddressTakenEv")
  //</editor-fold>
  public boolean hasAddressTaken() /*const*/ {
    return $ushort2int(getSubclassDataFromValue()) != 0;
  }


  /// \brief Update all phi nodes in this basic block's successors to refer to
  /// basic block \p New instead of to it.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::replaceSuccessorsPhiUsesWith">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 414,
   FQN="llvm::BasicBlock::replaceSuccessorsPhiUsesWith", NM="_ZN4llvm10BasicBlock28replaceSuccessorsPhiUsesWithEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock28replaceSuccessorsPhiUsesWithEPS0_")
  //</editor-fold>
  public void replaceSuccessorsPhiUsesWith(BasicBlock /*P*/ New) {
    TerminatorInst /*P*/ TI = getTerminator();
    if (!(TI != null)) {
      // Cope with being called on a BasicBlock that doesn't have a terminator
      // yet. Clang's CodeGenFunction::EmitReturnBlock() likes to do this.
      return;
    }
    for (BasicBlock /*P*/ Succ : TI.successors()) {
      // N.B. Succ might not be a complete BasicBlock, so don't assume
      // that it ends with a non-phi instruction.
      for (ilist_iterator<Instruction> II = Succ.begin(), IE = Succ.end(); II.$noteq(IE); II.$preInc()) {
        PHINode /*P*/ PN = $tryClone(dyn_cast_PHINode(II.$star()));
        if (!(PN != null)) {
          break;
        }
        int i;
        while ((i = PN.getBasicBlockIndex(this)) >= 0) {
          PN.setIncomingBlock(i, New);
        }
      }
    }
  }


  /// \brief Return true if this basic block is an exception handling block.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::isEHPad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 314,
   FQN="llvm::BasicBlock::isEHPad", NM="_ZNK4llvm10BasicBlock7isEHPadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZNK4llvm10BasicBlock7isEHPadEv")
  //</editor-fold>
  public boolean isEHPad() /*const*/ {
    return getFirstNonPHI$Const().isEHPad();
  }


  /// \brief Return true if this basic block is a landing pad.
  ///
  /// Being a ``landing pad'' means that the basic block is the destination of
  /// the 'unwind' edge of an invoke instruction.

  /// Return true if this basic block is a landing pad. I.e., it's
  /// the destination of the 'unwind' edge of an invoke instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::isLandingPad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 436,
   FQN="llvm::BasicBlock::isLandingPad", NM="_ZNK4llvm10BasicBlock12isLandingPadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZNK4llvm10BasicBlock12isLandingPadEv")
  //</editor-fold>
  public boolean isLandingPad() /*const*/ {
    return isa_LandingPadInst(getFirstNonPHI$Const());
  }


  /// \brief Return the landingpad instruction associated with the landing pad.

  /// Return the landingpad instruction associated with the landing pad.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getLandingPadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 441,
   FQN="llvm::BasicBlock::getLandingPadInst", NM="_ZN4llvm10BasicBlock17getLandingPadInstEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock17getLandingPadInstEv")
  //</editor-fold>
  public LandingPadInst /*P*/ getLandingPadInst() {
    return dyn_cast_LandingPadInst(getFirstNonPHI());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::getLandingPadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp", line = 444,
   FQN="llvm::BasicBlock::getLandingPadInst", NM="_ZNK4llvm10BasicBlock17getLandingPadInstEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZNK4llvm10BasicBlock17getLandingPadInstEv")
  //</editor-fold>
  public /*const*/ LandingPadInst /*P*/ getLandingPadInst$Const() /*const*/ {
    return dyn_cast_LandingPadInst(getFirstNonPHI$Const());
  }

/*private:*/
  /// \brief Increment the internal refcount of the number of BlockAddresses
  /// referencing this BasicBlock by \p Amt.
  ///
  /// This is almost always 0, sometimes one possibly, but almost never 2, and
  /// inconceivably 3 or more.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::AdjustBlockAddressRefCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 332,
   FQN="llvm::BasicBlock::AdjustBlockAddressRefCount", NM="_ZN4llvm10BasicBlock26AdjustBlockAddressRefCountEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock26AdjustBlockAddressRefCountEi")
  //</editor-fold>
  /*friend*/ /*package*/ void AdjustBlockAddressRefCount(int Amt) {
    setValueSubclassData_BasicBlock($int2ushort($ushort2int(getSubclassDataFromValue()) + Amt));
    assert ((int)(/*schar*/byte)$ushort2schar(getSubclassDataFromValue()) >= 0) : "Refcount wrap-around";
  }

  /// \brief Shadow Value::setValueSubclassData with a private forwarding method
  /// so that any future subclasses cannot accidentally use it.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlock::setValueSubclassData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 339,
   FQN="llvm::BasicBlock::setValueSubclassData", NM="_ZN4llvm10BasicBlock20setValueSubclassDataEt",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/BasicBlock.cpp -nm=_ZN4llvm10BasicBlock20setValueSubclassDataEt")
  //</editor-fold>
  private void setValueSubclassData_BasicBlock(/*ushort*/char D) {
    super.setValueSubclassData(D);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public java.util.Iterator<Instruction> iterator() {
    return new JavaIterator<>(begin(), end());
  }

  public static BasicBlock $createSentinel() {
    return new BasicBlock();
  }
  
  private BasicBlock() {
    this.ilist_node$Flds = $ilist_node_with_parent();
    this.InstList = null;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  private final ilist_node$Fields ilist_node$Flds;// use return value of $ilist_node_with_parent();
  @Override public final ilist_node$Fields $ilist_node$Fields() { return ilist_node$Flds; }

  @Override public String toString() {
    if ($isSentinel()) {
      return "Sentinel " + this.getClass().getSimpleName();
    }
    return "" + "InstList=" + InstList // NOI18N
              + ", Parent=" + Parent // NOI18N
              + super.toString(); // NOI18N
  }
}
