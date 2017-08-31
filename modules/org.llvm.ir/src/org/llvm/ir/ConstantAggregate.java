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
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.ir.java.*;


/// Base class for aggregate constants (with operands).
///
/// These constants are aggregates of other constants, which are stored as
/// operands.
///
/// Subclasses are \a ConstantStruct, \a ConstantArray, and \a
/// ConstantVector.
///
/// \note Some subclasses of \a ConstantData are semantically aggregates --
/// such as \a ConstantDataArray -- but are not subclasses of this because they
/// use operands.
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantAggregate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 368,
 FQN="llvm::ConstantAggregate", NM="_ZN4llvm17ConstantAggregateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm17ConstantAggregateE")
//</editor-fold>
public class ConstantAggregate extends /*public*/ Constant implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantAggregate::ConstantAggregate">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 871,
   FQN="llvm::ConstantAggregate::ConstantAggregate", NM="_ZN4llvm17ConstantAggregateC1EPNS_13CompositeTypeENS_5Value7ValueTyENS_8ArrayRefIPNS_8ConstantEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm17ConstantAggregateC1EPNS_13CompositeTypeENS_5Value7ValueTyENS_8ArrayRefIPNS_8ConstantEEE")
  //</editor-fold>
  protected ConstantAggregate(CompositeType /*P*/ T, Value.ValueTy VT,
      ArrayRef<Constant /*P*/ > V) {
    // : Constant(T, VT, OperandTraits<ConstantAggregate>::op_end(this) - V.size(), V.size())
    //START JInit
    super(T, VT, OperandTraitsConstantAggregate.<ConstantAggregate>op_end(User.$BEING_CREATED()).$sub(V.size()),
        V.size());
    //END JInit
    std.copy(V.begin(), V.end(), op_begin(), (source, dest)->dest.$star().$assign(source.$star()));
    {

      // Check that types match, unless this is an opaque struct.
      StructType /*P*/ ST = dyn_cast_StructType(T);
      if ((ST != null)) {
        if (ST.isOpaque()) {
          return;
        }
      }
    }
    for (/*uint*/int I = 0, E = V.size(); I != E; ++I)  {
      assert (V.$at(I).getType() == T.getTypeAtIndex(I)) : "Initializer for composite element doesn't match!";
    }
  }

/*public:*/
/// Transparently provide more efficient getOperand methods.
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantAggregate::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 387,
   FQN="llvm::ConstantAggregate::getOperand", NM="_ZNK4llvm17ConstantAggregate10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm17ConstantAggregate10getOperandEj")
  //</editor-fold>
  public Constant /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsConstantAggregate.<ConstantAggregate>operands(this))) : "getOperand() out of range!";
    return cast_or_null_Constant(OperandTraitsConstantAggregate.<ConstantAggregate>op_begin(((/*const_cast*/ConstantAggregate /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantAggregate::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 387,
   FQN="llvm::ConstantAggregate::setOperand", NM="_ZN4llvm17ConstantAggregate10setOperandEjPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm17ConstantAggregate10setOperandEjPNS_8ConstantE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Constant /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsConstantAggregate.<ConstantAggregate>operands(this))) : "setOperand() out of range!";
    OperandTraitsConstantAggregate.<ConstantAggregate>op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantAggregate::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 387,
   FQN="llvm::ConstantAggregate::op_begin", NM="_ZN4llvm17ConstantAggregate8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm17ConstantAggregate8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsConstantAggregate.<ConstantAggregate>op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantAggregate::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 387,
   FQN="llvm::ConstantAggregate::op_begin", NM="_ZNK4llvm17ConstantAggregate8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm17ConstantAggregate8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsConstantAggregate.<ConstantAggregate>op_begin(((/*const_cast*/ConstantAggregate /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantAggregate::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 387,
   FQN="llvm::ConstantAggregate::op_end", NM="_ZN4llvm17ConstantAggregate6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm17ConstantAggregate6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsConstantAggregate.<ConstantAggregate>op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantAggregate::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 387,
   FQN="llvm::ConstantAggregate::op_end", NM="_ZNK4llvm17ConstantAggregate6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm17ConstantAggregate6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsConstantAggregate.<ConstantAggregate>op_end(((/*const_cast*/ConstantAggregate /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantAggregate::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 387,
   FQN="llvm::ConstantAggregate::Op", NM="Tpl__ZN4llvm17ConstantAggregate2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=Tpl__ZN4llvm17ConstantAggregate2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this.OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantAggregate::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 387,
   FQN="llvm::ConstantAggregate::Op", NM="Tpl__ZNK4llvm17ConstantAggregate2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=Tpl__ZNK4llvm17ConstantAggregate2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this.OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantAggregate::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 387,
   FQN="llvm::ConstantAggregate::getNumOperands", NM="_ZNK4llvm17ConstantAggregate14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm17ConstantAggregate14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsConstantAggregate.<ConstantAggregate>operands(this);
  }


  /// Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantAggregate::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 377,
   FQN="llvm::ConstantAggregate::classof", NM="_ZN4llvm17ConstantAggregate7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm17ConstantAggregate7classofEPKNS_5ValueE")
  //</editor-fold>
  public static boolean classof(/*const*/ Value /*P*/ V) {
    return $greatereq_uint(V.getValueID(), ValueTy.ConstantAggregateFirstVal.getValue())
       && $lesseq_uint(V.getValueID(), ValueTy.ConstantAggregateLastVal.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantAggregate::~ConstantAggregate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 368,
   FQN="llvm::ConstantAggregate::~ConstantAggregate", NM="_ZN4llvm17ConstantAggregateD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm17ConstantAggregateD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
