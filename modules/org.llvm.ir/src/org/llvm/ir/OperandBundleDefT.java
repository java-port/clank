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
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IRFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.cl.*;
import org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.ir.java.IRMemberPointers.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import org.llvm.support.dwarf.Tag;
import org.llvm.support.sys.SmartRWMutex;
import org.llvm.ir.java.cst_pred_ty_Predicate;
import org.llvm.ir.legacy.PassManagerBase;
import org.llvm.ir.PassManagerGlobals.*;
import org.llvm.ir.java.MDNodeKeyImpl;
import static org.llvm.adt.HashingGlobals.*;


/// \brief A container for an operand bundle being viewed as a set of values
/// rather than a set of uses.
///
/// Unlike OperandBundleUse, OperandBundleDefT owns the memory it carries, and
/// so it is possible to create and pass around "self-contained" instances of
/// OperandBundleDef and ConstOperandBundleDef.
/*template <typename InputTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleDefT">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1242,
 FQN="llvm::OperandBundleDefT", NM="_ZN4llvm17OperandBundleDefTE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm17OperandBundleDefTE")
//</editor-fold>
public class OperandBundleDefT</*typename*/ InputTy>  implements Destructors.ClassWithDestructor {
  private std.string Tag;
  private std.vector<InputTy> Inputs;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleDefT::OperandBundleDefT<InputTy>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1247,
   FQN="llvm::OperandBundleDefT::OperandBundleDefT<InputTy>", NM="_ZN4llvm17OperandBundleDefTC1ESsSt6vectorIT_SaIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm17OperandBundleDefTC1ESsSt6vectorIT_SaIS2_EE")
  //</editor-fold>
  public /*explicit*/ OperandBundleDefT(std.string Tag, std.vector<InputTy> Inputs) {
    // : Tag(std::move(Tag)), Inputs(std::move(Inputs))
    //START JInit
    this.Tag = new std.string(JD$Move.INSTANCE, std.move(Tag));
    this.Inputs = /*ParenListExpr*/new std.vector<InputTy>(std.move(Inputs));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleDefT::OperandBundleDefT<InputTy>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1249,
   FQN="llvm::OperandBundleDefT::OperandBundleDefT<InputTy>", NM="_ZN4llvm17OperandBundleDefTC1ESsNS_8ArrayRefIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm17OperandBundleDefTC1ESsNS_8ArrayRefIT_EE")
  //</editor-fold>
  public /*explicit*/ OperandBundleDefT(std.string Tag, ArrayRef<InputTy> Inputs) {
    // : Tag(std::move(Tag)), Inputs(Inputs)
    //START JInit
    this.Tag = new std.string(JD$Move.INSTANCE, std.move(Tag));
    this.Inputs = /*ParenListExpr*/Inputs.$vector();
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleDefT::OperandBundleDefT<InputTy>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1252,
   FQN="llvm::OperandBundleDefT::OperandBundleDefT<InputTy>", NM="_ZN4llvm17OperandBundleDefTC1ERKNS_16OperandBundleUseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm17OperandBundleDefTC1ERKNS_16OperandBundleUseE")
  //</editor-fold>
  public /*explicit*/ OperandBundleDefT(final /*const*/ OperandBundleUse /*&*/ OBU, Converter<Use, InputTy> $Converter) {
    Tag = OBU.getTagName().$string();
    Inputs.insert$T(Inputs.end(), OBU.Inputs.begin(), OBU.Inputs.end(), $Converter);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleDefT::inputs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1257,
   FQN="llvm::OperandBundleDefT::inputs", NM="_ZNK4llvm17OperandBundleDefT6inputsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleDefT6inputsEv")
  //</editor-fold>
  public ArrayRef<InputTy> inputs() /*const*/ {
    return new ArrayRef(Inputs);
  }


  // JAVA: typedef typename std::vector<InputTy>::const_iterator input_iterator
//  public final class input_iterator extends std.vector.iterator<InputTy>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleDefT::input_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1260,
   FQN="llvm::OperandBundleDefT::input_size", NM="_ZNK4llvm17OperandBundleDefT10input_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleDefT10input_sizeEv")
  //</editor-fold>
  public /*size_t*/int input_size() /*const*/ {
    return Inputs.size();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleDefT::input_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1261,
   FQN="llvm::OperandBundleDefT::input_begin", NM="_ZNK4llvm17OperandBundleDefT11input_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleDefT11input_beginEv")
  //</editor-fold>
  public std.vector.iterator<InputTy> input_begin() /*const*/ {
    return Inputs.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleDefT::input_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1262,
   FQN="llvm::OperandBundleDefT::input_end", NM="_ZNK4llvm17OperandBundleDefT9input_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleDefT9input_endEv")
  //</editor-fold>
  public std.vector.iterator<InputTy> input_end() /*const*/ {
    return Inputs.end();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleDefT::getTag">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1264,
   FQN="llvm::OperandBundleDefT::getTag", NM="_ZNK4llvm17OperandBundleDefT6getTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleDefT6getTagEv")
  //</editor-fold>
  public StringRef getTag() /*const*/ {
    return new StringRef(Tag);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public void $destroy() {}

  public OperandBundleDefT() { }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "Tag=" + Tag // NOI18N
              + ", Inputs=" + Inputs; // NOI18N
  }
}
