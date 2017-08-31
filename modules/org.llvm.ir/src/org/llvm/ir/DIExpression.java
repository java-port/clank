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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import org.llvm.support.dwarf.LocationAtom;


/// \brief DWARF expression.
///
/// This is (almost) a DWARF expression that modifies the location of a
/// variable or (or the location of a single piece of a variable).
///
/// FIXME: Instead of DW_OP_plus taking an argument, this should use DW_OP_const
/// and have DW_OP_plus consume the topmost elements on the stack.
///
/// TODO: Co-allocate the expression elements.
/// TODO: Separate from MDNode, or otherwise drop Distinct and Temporary
/// storage types.
//<editor-fold defaultstate="collapsed" desc="llvm::DIExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2024,
 FQN="llvm::DIExpression", NM="_ZN4llvm12DIExpressionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIExpressionE")
//</editor-fold>
public class DIExpression extends /*public*/ MDNode implements Destructors.ClassWithDestructor {
  /*friend  class LLVMContextImpl*/
  /*friend  class MDNode*/

  private std.vectorULong Elements;

  //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::DIExpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2030,
   FQN="llvm::DIExpression::DIExpression", NM="_ZN4llvm12DIExpressionC1ERNS_11LLVMContextENS_8Metadata11StorageTypeENS_8ArrayRefIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIExpressionC1ERNS_11LLVMContextENS_8Metadata11StorageTypeENS_8ArrayRefIyEE")
  //</editor-fold>
  private DIExpression(final LLVMContext /*&*/ C, Metadata.StorageType Storage, ArrayRefULong Elements) {
    // : MDNode(C, DIExpressionKind, Storage, None), Elements(Elements.begin(), Elements.end())
    //START JInit
    /*ExprWithCleanups*/super(C, MetadataKind.DIExpressionKind.getValue(), Storage, new ArrayRef<Metadata /*P*/ >(None, true));
    this.Elements = new std.vectorULong(Elements.begin(), Elements.end());
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::~DIExpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2033,
   FQN="llvm::DIExpression::~DIExpression", NM="_ZN4llvm12DIExpressionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm12DIExpressionD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy()/* = default*/ {
    //START JDestroy
    Elements.$destroy();
    super.$destroy();
    //END JDestroy
  }



  //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::getImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 544,
   FQN="llvm::DIExpression::getImpl", NM="_ZN4llvm12DIExpression7getImplERNS_11LLVMContextENS_8ArrayRefIyEENS_8Metadata11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIExpression7getImplERNS_11LLVMContextENS_8ArrayRefIyEENS_8Metadata11StorageTypeEb")
  //</editor-fold>
  private static DIExpression /*P*/ getImpl(final LLVMContext /*&*/ Context,
         ArrayRefULong Elements,
         Metadata.StorageType Storage) {
    return getImpl(Context,
         Elements,
         Storage, true);
  }
  private static DIExpression /*P*/ getImpl(final LLVMContext /*&*/ Context,
         ArrayRefULong Elements,
         Metadata.StorageType Storage, boolean ShouldCreate/*= true*/) {
    do {
      if (Storage == StorageType.Uniqued) {
        {
          DIExpression /*P*/ N = IrLlvmStatics.getUniqued(Context.pImpl.DIExpressions, new MDNodeKeyImplDIExpression(new ArrayRefULong(Elements)));
          if ((N != null)) {
            return N;
          }
        }
        if (!ShouldCreate) {
          return null;
        }
      } else {
        assert (ShouldCreate) : "Expected non-uniqued nodes to always be created";
      }
    } while (false);
    return storeImpl(/*NEW_EXPR [MDNode::new]*//*new (0U)*/ MDNode.$new(0/*U*/, (type$ptr<?> New$Mem)->{
            return new DIExpression(Context, Storage, new ArrayRefULong(Elements));
         }), Storage, Context.pImpl.DIExpressions);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2039,
   FQN="llvm::DIExpression::cloneImpl", NM="_ZNK4llvm12DIExpression9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIExpression9cloneImplEv")
  //</editor-fold>
  /*friend*//*private*/ std.unique_ptr_with_deleter<DIExpression /*, TempMDNodeDeleter*/> cloneImpl() /*const*/ {
    return DIExpression.getTemporary(getContext(), getElements());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2044,
   FQN="llvm::DIExpression::get", NM="_ZN4llvm12DIExpression3getERNS_11LLVMContextENS_8ArrayRefIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIExpression3getERNS_11LLVMContextENS_8ArrayRefIyEE")
  //</editor-fold>
  public static DIExpression /*P*/ get(final LLVMContext /*&*/ Context, ArrayRefULong Elements) {
    return getImpl(Context, new ArrayRefULong(Elements), StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2044,
   FQN="llvm::DIExpression::getIfExists", NM="_ZN4llvm12DIExpression11getIfExistsERNS_11LLVMContextENS_8ArrayRefIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIExpression11getIfExistsERNS_11LLVMContextENS_8ArrayRefIyEE")
  //</editor-fold>
  public static DIExpression /*P*/ getIfExists(final LLVMContext /*&*/ Context, ArrayRefULong Elements) {
    return getImpl(Context, new ArrayRefULong(Elements), StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2044,
   FQN="llvm::DIExpression::getDistinct", NM="_ZN4llvm12DIExpression11getDistinctERNS_11LLVMContextENS_8ArrayRefIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIExpression11getDistinctERNS_11LLVMContextENS_8ArrayRefIyEE")
  //</editor-fold>
  public static DIExpression /*P*/ getDistinct(final LLVMContext /*&*/ Context, ArrayRefULong Elements) {
    return getImpl(Context, new ArrayRefULong(Elements), StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2044,
   FQN="llvm::DIExpression::getTemporary", NM="_ZN4llvm12DIExpression12getTemporaryERNS_11LLVMContextENS_8ArrayRefIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIExpression12getTemporaryERNS_11LLVMContextENS_8ArrayRefIyEE")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DIExpression /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, ArrayRefULong Elements) {
    return new std.unique_ptr_with_deleter<DIExpression /*, TempMDNodeDeleter*/>(getImpl(Context, new ArrayRefULong(Elements), StorageType.Temporary));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2046,
   FQN="llvm::DIExpression::clone", NM="_ZNK4llvm12DIExpression5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIExpression5cloneEv")
  //</editor-fold>
  public std.unique_ptr_with_deleter<DIExpression /*, TempMDNodeDeleter*/> clone() /*const*/ {
    return cloneImpl();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::getElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2048,
   FQN="llvm::DIExpression::getElements", NM="_ZNK4llvm12DIExpression11getElementsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIExpression11getElementsEv")
  //</editor-fold>
  public ArrayRefULong getElements() /*const*/ {
    return new ArrayRefULong(Elements);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::getNumElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2050,
   FQN="llvm::DIExpression::getNumElements", NM="_ZNK4llvm12DIExpression14getNumElementsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIExpression14getNumElementsEv")
  //</editor-fold>
  public /*uint*/int getNumElements() /*const*/ {
    return Elements.size();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::getElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2051,
   FQN="llvm::DIExpression::getElement", NM="_ZNK4llvm12DIExpression10getElementEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIExpression10getElementEj")
  //</editor-fold>
  public long/*uint64_t*/ getElement(/*uint*/int I) /*const*/ {
    assert ($less_uint(I, Elements.size())) : "Index out of range";
    return Elements.$at$Const(I);
  }


  /// \brief Return whether this is a piece of an aggregate variable.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::isBitPiece">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 585,
   FQN="llvm::DIExpression::isBitPiece", NM="_ZNK4llvm12DIExpression10isBitPieceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIExpression10isBitPieceEv")
  //</editor-fold>
  public boolean isBitPiece() /*const*/ {
    assert (isValid()) : "Expected valid expression";
    {
      /*uint*/int N = getNumElements();
      if ((N != 0)) {
        if ($greatereq_uint(N, 3)) {
          return getElement(N - 3) == $uint2ullong(LocationAtom.DW_OP_bit_piece);
        }
      }
    }
    return false;
  }


  /// \brief Return the offset of this piece in bits.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::getBitPieceOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 593,
   FQN="llvm::DIExpression::getBitPieceOffset", NM="_ZNK4llvm12DIExpression17getBitPieceOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIExpression17getBitPieceOffsetEv")
  //</editor-fold>
  public long/*uint64_t*/ getBitPieceOffset() /*const*/ {
    assert (isBitPiece()) : "Expected bit piece";
    return getElement(getNumElements() - 2);
  }


  /// \brief Return the size of this piece in bits.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::getBitPieceSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 598,
   FQN="llvm::DIExpression::getBitPieceSize", NM="_ZNK4llvm12DIExpression15getBitPieceSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIExpression15getBitPieceSizeEv")
  //</editor-fold>
  public long/*uint64_t*/ getBitPieceSize() /*const*/ {
    assert (isBitPiece()) : "Expected bit piece";
    return getElement(getNumElements() - 1);
  }


  // JAVA: typedef ArrayRef<uint64_t>::iterator element_iterator;
  //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::elements_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2066,
   FQN="llvm::DIExpression::elements_begin", NM="_ZNK4llvm12DIExpression14elements_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIExpression14elements_beginEv")
  //</editor-fold>
  public /*const*//*ullong*/ulong$ptr/*P*/ elements_begin() /*const*/ {
    return getElements().begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::elements_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2067,
   FQN="llvm::DIExpression::elements_end", NM="_ZNK4llvm12DIExpression12elements_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIExpression12elements_endEv")
  //</editor-fold>
  public /*const*//*ullong*/ulong$ptr/*P*/ elements_end() /*const*/ {
    return getElements().end();
  }


  /// \brief A lightweight wrapper around an expression operand.
  ///
  /// TODO: Store arguments directly and change \a DIExpression to store a
  /// range of these.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::ExprOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2073,
   FQN="llvm::DIExpression::ExprOperand", NM="_ZN4llvm12DIExpression11ExprOperandE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIExpression11ExprOperandE")
  //</editor-fold>
  public static class ExprOperand {
    private /*const*/ulong$ptr/*uint64_t P*/ Op;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::ExprOperand::ExprOperand">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2077,
     FQN="llvm::DIExpression::ExprOperand::ExprOperand", NM="_ZN4llvm12DIExpression11ExprOperandC1EPKy",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIExpression11ExprOperandC1EPKy")
    //</editor-fold>
    public /*explicit*/ ExprOperand(/*const*/ulong$ptr/*uint64_t P*/ Op) {
      // : Op(Op)
      //START JInit
      this.Op = $tryClone(Op);
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::ExprOperand::get">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2079,
     FQN="llvm::DIExpression::ExprOperand::get", NM="_ZNK4llvm12DIExpression11ExprOperand3getEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIExpression11ExprOperand3getEv")
    //</editor-fold>
    public /*const*/ulong$ptr/*uint64_t P*/ get() /*const*/ {
      return Op;
    }


    /// \brief Get the operand code.
    //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::ExprOperand::getOp">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2082,
     FQN="llvm::DIExpression::ExprOperand::getOp", NM="_ZNK4llvm12DIExpression11ExprOperand5getOpEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIExpression11ExprOperand5getOpEv")
    //</editor-fold>
    public long/*uint64_t*/ getOp() /*const*/ {
      return Op.$star();
    }


    /// \brief Get an argument to the operand.
    ///
    /// Never returns the operand itself.
    //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::ExprOperand::getArg">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2087,
     FQN="llvm::DIExpression::ExprOperand::getArg", NM="_ZNK4llvm12DIExpression11ExprOperand6getArgEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIExpression11ExprOperand6getArgEj")
    //</editor-fold>
    public long/*uint64_t*/ getArg(/*uint*/int I) /*const*/ {
      return Op.$at(I + 1);
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::ExprOperand::getNumArgs">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2089,
     FQN="llvm::DIExpression::ExprOperand::getNumArgs", NM="_ZNK4llvm12DIExpression11ExprOperand10getNumArgsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIExpression11ExprOperand10getNumArgsEv")
    //</editor-fold>
    public /*uint*/int getNumArgs() /*const*/ {
      return getSize() - 1;
    }


    /// \brief Return the size of the operand.
    ///
    /// Return the number of elements in the operand (1 + args).
    //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::ExprOperand::getSize">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 551,
     FQN="llvm::DIExpression::ExprOperand::getSize", NM="_ZNK4llvm12DIExpression11ExprOperand7getSizeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIExpression11ExprOperand7getSizeEv")
    //</editor-fold>
    public /*uint*/int getSize() /*const*/ {
      switch ((int)getOp()) {
       case LocationAtom.DW_OP_bit_piece:
        return 3;
       case LocationAtom.DW_OP_plus:
       case LocationAtom.DW_OP_minus:
        return 2;
       default:
        return 1;
      }
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::ExprOperand::ExprOperand">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2073,
     FQN="llvm::DIExpression::ExprOperand::ExprOperand", NM="_ZN4llvm12DIExpression11ExprOperandC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIExpression11ExprOperandC1ERKS1_")
    //</editor-fold>
    public /*inline*/ ExprOperand(final /*const*/ ExprOperand /*&*/ $Prm0) {
      // : Op(.Op)
      //START JInit
      this.Op = $tryClone($Prm0.Op);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::ExprOperand::ExprOperand">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2073,
     FQN="llvm::DIExpression::ExprOperand::ExprOperand", NM="_ZN4llvm12DIExpression11ExprOperandC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIExpression11ExprOperandC1EOS1_")
    //</editor-fold>
    public /*inline*/ ExprOperand(JD$Move _dparam, final ExprOperand /*&&*/$Prm0) {
      // : Op(static_cast<ExprOperand &&>().Op)
      //START JInit
      this.Op = $tryClone($Prm0.Op);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::ExprOperand::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2073,
     FQN="llvm::DIExpression::ExprOperand::operator=", NM="_ZN4llvm12DIExpression11ExprOperandaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIExpression11ExprOperandaSEOS1_")
    //</editor-fold>
    public /*inline*/ ExprOperand /*&*/ $assignMove(final ExprOperand /*&&*/$Prm0) {
      this.Op = $tryClone($Prm0.Op);
      return /*Deref*/this;
    }


    @Override public String toString() {
      return "" + "Op=" + Op; // NOI18N
    }
  };

  /// \brief An iterator for expression operands.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::expr_op_iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2098,
   FQN="llvm::DIExpression::expr_op_iterator", NM="_ZN4llvm12DIExpression16expr_op_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIExpression16expr_op_iteratorE")
  //</editor-fold>
  public static class expr_op_iterator implements /*public*/ std.iterator<std.input_iterator_tag, ExprOperand>, Native.NativeComparable<expr_op_iterator> {
    private ExprOperand Op;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::expr_op_iterator::expr_op_iterator">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2103,
     FQN="llvm::DIExpression::expr_op_iterator::expr_op_iterator", NM="_ZN4llvm12DIExpression16expr_op_iteratorC1EPKy",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIExpression16expr_op_iteratorC1EPKy")
    //</editor-fold>
    public /*explicit*/ expr_op_iterator(/*const*//*ullong*/ulong$ptr/*P*/ I) {
      // : std::iterator<std::input_iterator_tag, ExprOperand>(), Op(I)
      //START JInit
      $iterator();
      this.Op = new ExprOperand(I);
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::expr_op_iterator::getBase">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2105,
     FQN="llvm::DIExpression::expr_op_iterator::getBase", NM="_ZNK4llvm12DIExpression16expr_op_iterator7getBaseEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIExpression16expr_op_iterator7getBaseEv")
    //</editor-fold>
    public /*const*//*ullong*/ulong$ptr/*P*/ getBase() /*const*/ {
      return Op.get();
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::expr_op_iterator::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2106,
     FQN="llvm::DIExpression::expr_op_iterator::operator*", NM="_ZNK4llvm12DIExpression16expr_op_iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIExpression16expr_op_iteratordeEv")
    //</editor-fold>
    public /*const*/ ExprOperand /*&*/ $star() /*const*/ {
      return Op;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::expr_op_iterator::operator->">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2107,
     FQN="llvm::DIExpression::expr_op_iterator::operator->", NM="_ZNK4llvm12DIExpression16expr_op_iteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIExpression16expr_op_iteratorptEv")
    //</editor-fold>
    public /*const*/ ExprOperand /*P*/ $arrow() /*const*/ {
      return $AddrOf(Op);
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::expr_op_iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2109,
     FQN="llvm::DIExpression::expr_op_iterator::operator++", NM="_ZN4llvm12DIExpression16expr_op_iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIExpression16expr_op_iteratorppEv")
    //</editor-fold>
    public expr_op_iterator /*&*/ $preInc() {
      increment();
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::expr_op_iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2113,
     FQN="llvm::DIExpression::expr_op_iterator::operator++", NM="_ZN4llvm12DIExpression16expr_op_iteratorppEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIExpression16expr_op_iteratorppEi")
    //</editor-fold>
    public expr_op_iterator $postInc(int $Prm0) {
      expr_op_iterator T/*J*/= new expr_op_iterator(/*Deref*/this);
      increment();
      return T;
    }


    /// \brief Get the next iterator.
    ///
    /// \a std::next() doesn't work because this is technically an
    /// input_iterator, but it's a perfectly valid operation.  This is an
    /// accessor to provide the same functionality.
    //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::expr_op_iterator::getNext">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2124,
     FQN="llvm::DIExpression::expr_op_iterator::getNext", NM="_ZNK4llvm12DIExpression16expr_op_iterator7getNextEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIExpression16expr_op_iterator7getNextEv")
    //</editor-fold>
    public expr_op_iterator getNext() /*const*/ {
      return new expr_op_iterator(new expr_op_iterator(/*Deref*/this).$preInc());
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::expr_op_iterator::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2126,
     FQN="llvm::DIExpression::expr_op_iterator::operator==", NM="_ZNK4llvm12DIExpression16expr_op_iteratoreqERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIExpression16expr_op_iteratoreqERKS1_")
    //</editor-fold>
    public boolean $eq(final /*const*/ expr_op_iterator /*&*/ X) /*const*/ {
      return $eq_ptr(getBase(), X.getBase());
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::expr_op_iterator::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2129,
     FQN="llvm::DIExpression::expr_op_iterator::operator!=", NM="_ZNK4llvm12DIExpression16expr_op_iteratorneERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIExpression16expr_op_iteratorneERKS1_")
    //</editor-fold>
    public boolean $noteq(final /*const*/ expr_op_iterator /*&*/ X) /*const*/ {
      return $noteq_ptr(getBase(), X.getBase());
    }

  /*private:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::expr_op_iterator::increment">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2134,
     FQN="llvm::DIExpression::expr_op_iterator::increment", NM="_ZN4llvm12DIExpression16expr_op_iterator9incrementEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIExpression16expr_op_iterator9incrementEv")
    //</editor-fold>
    private void increment() {
      this.Op.$assignMove(new ExprOperand(getBase().$add(Op.getSize())));
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::expr_op_iterator::expr_op_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2098,
     FQN="llvm::DIExpression::expr_op_iterator::expr_op_iterator", NM="_ZN4llvm12DIExpression16expr_op_iteratorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIExpression16expr_op_iteratorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ expr_op_iterator(final /*const*/ expr_op_iterator /*&*/ $Prm0) {
      // : std::iterator<std::input_iterator_tag, ExprOperand>(), Op(.Op)
      //START JInit
      $iterator($Prm0);
      this.Op = new ExprOperand($Prm0.Op);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::expr_op_iterator::expr_op_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2098,
     FQN="llvm::DIExpression::expr_op_iterator::expr_op_iterator", NM="_ZN4llvm12DIExpression16expr_op_iteratorC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIExpression16expr_op_iteratorC1EOS1_")
    //</editor-fold>
    public /*inline*/ expr_op_iterator(JD$Move _dparam, final expr_op_iterator /*&&*/$Prm0) {
      // : std::iterator<std::input_iterator_tag, ExprOperand>(static_cast<expr_op_iterator &&>()), Op(static_cast<expr_op_iterator &&>().Op)
      //START JInit
      $iterator(JD$Move.INSTANCE, $Prm0);
      this.Op = new ExprOperand(JD$Move.INSTANCE, $Prm0.Op);
      //END JInit
    }


    @Override public String toString() {
      return "" + "Op=" + Op // NOI18N
                + super.toString(); // NOI18N
    }
  };

  /// \brief Visit the elements via ExprOperand wrappers.
  ///
  /// These range iterators visit elements through \a ExprOperand wrappers.
  /// This is not guaranteed to be a valid range unless \a isValid() gives \c
  /// true.
  ///
  /// \pre \a isValid() gives \c true.
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::expr_op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2145,
   FQN="llvm::DIExpression::expr_op_begin", NM="_ZNK4llvm12DIExpression13expr_op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIExpression13expr_op_beginEv")
  //</editor-fold>
  public expr_op_iterator expr_op_begin() /*const*/ {
    return new expr_op_iterator(elements_begin());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::expr_op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2148,
   FQN="llvm::DIExpression::expr_op_end", NM="_ZNK4llvm12DIExpression11expr_op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIExpression11expr_op_endEv")
  //</editor-fold>
  public expr_op_iterator expr_op_end() /*const*/ {
    return new expr_op_iterator(elements_end());
  }

  /// @}
  //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::isValid">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 563,
   FQN="llvm::DIExpression::isValid", NM="_ZNK4llvm12DIExpression7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIExpression7isValidEv")
  //</editor-fold>
  public boolean isValid() /*const*/ {
    for (expr_op_iterator I = expr_op_begin(), E = expr_op_end(); I.$noteq(E); I.$preInc()) {
      // Check that there's space for the operand.
      if (I.$arrow().get().$add(I.$arrow().getSize()).$greater(E.$arrow().get())) {
        return false;
      }

      // Check that the operand is valid.
      switch ((int)I.$arrow().getOp()) {
       default:
        return false;
       case LocationAtom.DW_OP_bit_piece:
        // Piece expressions must be at the end.
        return $eq_ptr(I.$arrow().get().$add(I.$arrow().getSize()), E.$arrow().get());
       case LocationAtom.DW_OP_plus:
       case LocationAtom.DW_OP_minus:
       case LocationAtom.DW_OP_deref:
        break;
      }
    }
    return true;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIExpression::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2155,
   FQN="llvm::DIExpression::classof", NM="_ZN4llvm12DIExpression7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIExpression7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.DIExpressionKind.getValue();
  }


  @Override public String toString() {
    return "" + "Elements=" + Elements // NOI18N
              + super.toString(); // NOI18N
  }
}
