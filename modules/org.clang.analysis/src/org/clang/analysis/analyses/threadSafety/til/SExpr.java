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

package org.clang.analysis.analyses.threadSafety.til;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import static org.clang.analysis.analyses.ThreadSafetyUtilGlobals.*;


/// Base class for AST nodes in the typed intermediate language.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 260,
 FQN="clang::threadSafety::til::SExpr", NM="_ZN5clang12threadSafety3til5SExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til5SExprE")
//</editor-fold>
public class SExpr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SExpr::opcode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 262,
   FQN="clang::threadSafety::til::SExpr::opcode", NM="_ZNK5clang12threadSafety3til5SExpr6opcodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til5SExpr6opcodeEv")
  //</editor-fold>
  public TIL_Opcode opcode() /*const*/ {
    return /*static_cast*/TIL_Opcode.valueOf(Opcode);
  }

  
  // Subclasses of SExpr must define the following:
  //
  // This(const This& E, ...) {
  //   copy constructor: construct copy of E, with some additional arguments.
  // }
  //
  // template <class V>
  // typename V::R_SExpr traverse(V &Vs, typename V::R_Ctx Ctx) {
  //   traverse all subexpressions, following the traversal/rewriter interface.
  // }
  //
  // template <class C> typename C::CType compare(CType* E, C& Cmp) {
  //   compare all subexpressions, following the comparator interface
  // }
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SExpr::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 278,
   FQN="clang::threadSafety::til::SExpr::operator new", NM="_ZN5clang12threadSafety3til5SExprnwEjRNS1_12MemRegionRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til5SExprnwEjRNS1_12MemRegionRefE")
  //</editor-fold>
  public static Object/*void P*/ $new(/*size_t*/int S, final MemRegionRef /*&*/ R) {
    return /*::*/$new_uint_MemRegionRef(S, R);
  }

  
  /// SExpr objects cannot be deleted.
  // This declaration is public to workaround a gcc bug that breaks building
  // with REQUIRES_EH=1.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SExpr::operator delete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 285,
   FQN="clang::threadSafety::til::SExpr::operator delete", NM="_ZN5clang12threadSafety3til5SExprdlEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til5SExprdlEPv")
  //</editor-fold>
  public static void $delete(Object/*void P*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  /// Returns the instruction ID for this expression.
  /// All basic block instructions have a unique ID (i.e. virtual register).
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SExpr::id">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 289,
   FQN="clang::threadSafety::til::SExpr::id", NM="_ZNK5clang12threadSafety3til5SExpr2idEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til5SExpr2idEv")
  //</editor-fold>
  public /*uint*/int id() /*const*/ {
    return SExprID;
  }

  
  /// Returns the block, if this is an instruction in a basic block,
  /// otherwise returns null.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SExpr::block">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 293,
   FQN="clang::threadSafety::til::SExpr::block", NM="_ZNK5clang12threadSafety3til5SExpr5blockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til5SExpr5blockEv")
  //</editor-fold>
  public BasicBlock /*P*/ block() /*const*/ {
    return Block;
  }

  
  /// Set the basic block and instruction ID for this expression.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SExpr::setID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 296,
   FQN="clang::threadSafety::til::SExpr::setID", NM="_ZN5clang12threadSafety3til5SExpr5setIDEPNS1_10BasicBlockEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til5SExpr5setIDEPNS1_10BasicBlockEj")
  //</editor-fold>
  public void setID(BasicBlock /*P*/ B, /*uint*/int id) {
    Block = B;
    SExprID = id;
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SExpr::SExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 299,
   FQN="clang::threadSafety::til::SExpr::SExpr", NM="_ZN5clang12threadSafety3til5SExprC1ENS1_10TIL_OpcodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til5SExprC1ENS1_10TIL_OpcodeE")
  //</editor-fold>
  protected SExpr(TIL_Opcode Op) {
    // : Opcode(Op), Reserved(0), Flags(0), SExprID(0), Block(null) 
    //START JInit
    this.Opcode = $uint2char(Op.getValue());
    this.Reserved = $int2uchar(0);
    this.Flags = $int2ushort(0);
    this.SExprID = 0;
    this.Block = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SExpr::SExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 301,
   FQN="clang::threadSafety::til::SExpr::SExpr", NM="_ZN5clang12threadSafety3til5SExprC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til5SExprC1ERKS2_")
  //</editor-fold>
  protected SExpr(final /*const*/ SExpr /*&*/ E) {
    // : Opcode(E.Opcode), Reserved(0), Flags(E.Flags), SExprID(0), Block(null) 
    //START JInit
    this.Opcode = E.Opcode;
    this.Reserved = $int2uchar(0);
    this.Flags = E.Flags;
    this.SExprID = 0;
    this.Block = null;
    //END JInit
  }

  
  protected /*const*//*uchar*/byte Opcode;
  protected /*uchar*/byte Reserved;
  protected /*ushort*/char Flags;
  protected /*uint*/int SExprID;
  protected BasicBlock /*P*/ Block;
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SExpr::SExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 312,
   FQN="clang::threadSafety::til::SExpr::SExpr", NM="_ZN5clang12threadSafety3til5SExprC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til5SExprC1Ev")
  //</editor-fold>
  private SExpr() { throw new UnsupportedOperationException("Deleted");}

  
  /// SExpr objects must be created in an arena.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SExpr::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 315,
   FQN="clang::threadSafety::til::SExpr::operator new", NM="_ZN5clang12threadSafety3til5SExprnwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til5SExprnwEj")
  //</editor-fold>
  private static Object/*void P*/ $new(/*size_t*/int $Prm0) { throw new UnsupportedOperationException("Deleted");}

  public static <T extends SExpr> T/* P*/ $new(final MemRegionRef /*&*/ R, New$ConstructorCallback<T/*P*/> New$SExpr) {
//    return /*::*/$new_uint_MemRegionRef(S, R);
    return New$SExpr.$call(null);
  }
  
  @Override public String toString() {
    return "" + "Opcode=" + $uchar2uint(Opcode) // NOI18N
              + ", Reserved=" + $uchar2uint(Reserved) // NOI18N
              + ", Flags=" + $ushort2uint(Flags) // NOI18N
              + ", SExprID=" + SExprID // NOI18N
              + ", Block=" + Block; // NOI18N
  }
}
