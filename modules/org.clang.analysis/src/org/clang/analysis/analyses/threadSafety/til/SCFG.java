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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import static org.clang.analysis.impl.ThreadSafetyTILStatics.*;


/// An SCFG is a control-flow graph.  It consists of a set of basic blocks,
/// each of which terminates in a branch to another basic block.  There is one
/// entry point, and one exit point.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SCFG">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1686,
 FQN="clang::threadSafety::til::SCFG", NM="_ZN5clang12threadSafety3til4SCFGE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til4SCFGE")
//</editor-fold>
public class SCFG extends /*public*/ SExpr implements Iterable<BasicBlock> {
/*public:*/
  /*typedef SimpleArray<BasicBlock *> BlockArray*/
//  public final class BlockArray extends SimpleArray<BasicBlock /*P*/ >{ };
  /*typedef BlockArray::iterator iterator*/
//  public final class iterator extends type$ptr<BasicBlock /*P*/ /*P*/>{ };
  /*typedef BlockArray::const_iterator const_iterator*/
//  public final class const_iterator extends type$ptr<BasicBlock /*P*/ /*const*/ /*P*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SCFG::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1692,
   FQN="clang::threadSafety::til::SCFG::classof", NM="_ZN5clang12threadSafety3til4SCFG7classofEPKNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til4SCFG7classofEPKNS1_5SExprE")
  //</editor-fold>
  public static boolean classof(/*const*/ SExpr /*P*/ E) {
    return E.opcode() == TIL_Opcode.COP_SCFG;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SCFG::SCFG">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1694,
   FQN="clang::threadSafety::til::SCFG::SCFG", NM="_ZN5clang12threadSafety3til4SCFGC1ENS1_12MemRegionRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til4SCFGC1ENS1_12MemRegionRefEj")
  //</editor-fold>
  public SCFG(MemRegionRef A, /*uint*/int Nblocks) {
    // : SExpr(COP_SCFG), Arena(A), Blocks(A, Nblocks), Entry(null), Exit(null), NumInstructions(0), Normal(false) 
    //START JInit
    super(TIL_Opcode.COP_SCFG);
    this.Arena = new MemRegionRef(A);
    this.Blocks = new SimpleArray<BasicBlock /*P*/ >(new MemRegionRef(A), Nblocks);
    this.Entry = null;
    this.Exit = null;
    this.NumInstructions = 0;
    this.Normal = false;
    //END JInit
    Entry = /*NEW_EXPR [SExpr::new]*//*A = *//*new (A)*/ SExpr.$new(A, (type$ptr<?> New$Mem)->{
        return new BasicBlock(new MemRegionRef(A));
     });
    Exit = /*NEW_EXPR [SExpr::new]*//*A = *//*new (A)*/ SExpr.$new(A, (type$ptr<?> New$Mem)->{
        return new BasicBlock(new MemRegionRef(A));
     });
    Phi /*P*/ V = /*NEW_EXPR [SExpr::new]*//*A = *//*new (A)*/ SExpr.$new(A, (type$ptr<?> New$Mem)->{
        return new Phi();
     });
    Exit.addArgument(V);
    Exit.setTerminator(/*NEW_EXPR [SExpr::new]*//*A = *//*new (A)*/ SExpr.$new(A, (type$ptr<?> New$Mem)->{
            return new Return(V);
         }));
    add(Entry);
    add(Exit);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SCFG::SCFG">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1705,
   FQN="clang::threadSafety::til::SCFG::SCFG", NM="_ZN5clang12threadSafety3til4SCFGC1ERKS2_ONS1_11SimpleArrayIPNS1_10BasicBlockEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til4SCFGC1ERKS2_ONS1_11SimpleArrayIPNS1_10BasicBlockEEE")
  //</editor-fold>
  public SCFG(final /*const*/ SCFG /*&*/ Cfg, final SimpleArray<BasicBlock /*P*/ > /*&&*/Ba) {
    // : SExpr(COP_SCFG), Arena(Cfg.Arena), Blocks(std::move(Ba)), Entry(null), Exit(null), NumInstructions(0), Normal(false) 
    //START JInit
    // steals memory from Ba
    super(TIL_Opcode.COP_SCFG);
    this.Arena = new MemRegionRef(Cfg.Arena);
    this.Blocks = new SimpleArray<BasicBlock /*P*/ >(JD$Move.INSTANCE, std.move(Ba));
    this.Entry = null;
    this.Exit = null;
    this.NumInstructions = 0;
    this.Normal = false;
    //END JInit
    // TODO: set entry and exit!
  }

  
  /// Return true if this CFG is valid.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SCFG::valid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1712,
   FQN="clang::threadSafety::til::SCFG::valid", NM="_ZNK5clang12threadSafety3til4SCFG5validEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til4SCFG5validEv")
  //</editor-fold>
  public boolean valid() /*const*/ {
    return (Entry != null) && (Exit != null) && $greater_uint(Blocks.size(), 0);
  }

  
  /// Return true if this CFG has been normalized.
  /// After normalization, blocks are in topological order, and block and
  /// instruction IDs have been assigned.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SCFG::normal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1717,
   FQN="clang::threadSafety::til::SCFG::normal", NM="_ZNK5clang12threadSafety3til4SCFG6normalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til4SCFG6normalEv")
  //</editor-fold>
  public boolean normal() /*const*/ {
    return Normal;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SCFG::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1719,
   FQN="clang::threadSafety::til::SCFG::begin", NM="_ZN5clang12threadSafety3til4SCFG5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til4SCFG5beginEv")
  //</editor-fold>
  public type$ptr<BasicBlock /*P*/ /*P*/> begin() {
    return Blocks.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SCFG::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1720,
   FQN="clang::threadSafety::til::SCFG::end", NM="_ZN5clang12threadSafety3til4SCFG3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til4SCFG3endEv")
  //</editor-fold>
  public type$ptr<BasicBlock /*P*/ /*P*/> end() {
    return Blocks.end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SCFG::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1722,
   FQN="clang::threadSafety::til::SCFG::begin", NM="_ZNK5clang12threadSafety3til4SCFG5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til4SCFG5beginEv")
  //</editor-fold>
  public type$ptr<BasicBlock /*P*/ /*const*/ /*P*/> begin$Const() /*const*/ {
    return cbegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SCFG::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1723,
   FQN="clang::threadSafety::til::SCFG::end", NM="_ZNK5clang12threadSafety3til4SCFG3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til4SCFG3endEv")
  //</editor-fold>
  public type$ptr<BasicBlock /*P*/ /*const*/ /*P*/> end$Const() /*const*/ {
    return cend();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SCFG::cbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1725,
   FQN="clang::threadSafety::til::SCFG::cbegin", NM="_ZNK5clang12threadSafety3til4SCFG6cbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til4SCFG6cbeginEv")
  //</editor-fold>
  public type$ptr<BasicBlock /*P*/ /*const*/ /*P*/> cbegin() /*const*/ {
    return Blocks.cbegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SCFG::cend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1726,
   FQN="clang::threadSafety::til::SCFG::cend", NM="_ZNK5clang12threadSafety3til4SCFG4cendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til4SCFG4cendEv")
  //</editor-fold>
  public type$ptr<BasicBlock /*P*/ /*const*/ /*P*/> cend() /*const*/ {
    return Blocks.cend();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SCFG::entry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1728,
   FQN="clang::threadSafety::til::SCFG::entry", NM="_ZNK5clang12threadSafety3til4SCFG5entryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til4SCFG5entryEv")
  //</editor-fold>
  public /*const*/ BasicBlock /*P*/ entry$Const() /*const*/ {
    return Entry;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SCFG::entry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1729,
   FQN="clang::threadSafety::til::SCFG::entry", NM="_ZN5clang12threadSafety3til4SCFG5entryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til4SCFG5entryEv")
  //</editor-fold>
  public BasicBlock /*P*/ entry() {
    return Entry;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SCFG::exit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1730,
   FQN="clang::threadSafety::til::SCFG::exit", NM="_ZNK5clang12threadSafety3til4SCFG4exitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til4SCFG4exitEv")
  //</editor-fold>
  public /*const*/ BasicBlock /*P*/ exit$Const() /*const*/ {
    return Exit;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SCFG::exit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1731,
   FQN="clang::threadSafety::til::SCFG::exit", NM="_ZN5clang12threadSafety3til4SCFG4exitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til4SCFG4exitEv")
  //</editor-fold>
  public BasicBlock /*P*/ exit() {
    return Exit;
  }

  
  /// Return the number of blocks in the CFG.
  /// Block::blockID() will return a number less than numBlocks();
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SCFG::numBlocks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1735,
   FQN="clang::threadSafety::til::SCFG::numBlocks", NM="_ZNK5clang12threadSafety3til4SCFG9numBlocksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til4SCFG9numBlocksEv")
  //</editor-fold>
  public /*size_t*/int numBlocks() /*const*/ {
    return Blocks.size();
  }

  
  /// Return the total number of instructions in the CFG.
  /// This is useful for building instruction side-tables;
  /// A call to SExpr::id() will return a number less than numInstructions().
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SCFG::numInstructions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1740,
   FQN="clang::threadSafety::til::SCFG::numInstructions", NM="_ZN5clang12threadSafety3til4SCFG15numInstructionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til4SCFG15numInstructionsEv")
  //</editor-fold>
  public /*uint*/int numInstructions() {
    return NumInstructions;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SCFG::add">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1742,
   FQN="clang::threadSafety::til::SCFG::add", NM="_ZN5clang12threadSafety3til4SCFG3addEPNS1_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til4SCFG3addEPNS1_10BasicBlockE")
  //</editor-fold>
  public /*inline*/ void add(BasicBlock /*P*/ BB) {
    assert (BB.CFGPtr == null);
    BB.CFGPtr = this;
    Blocks.reserveCheck(1, new MemRegionRef(Arena));
    Blocks.push_back(BB);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SCFG::setEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1749,
   FQN="clang::threadSafety::til::SCFG::setEntry", NM="_ZN5clang12threadSafety3til4SCFG8setEntryEPNS1_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til4SCFG8setEntryEPNS1_10BasicBlockE")
  //</editor-fold>
  public void setEntry(BasicBlock /*P*/ BB) {
    Entry = BB;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SCFG::setExit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1750,
   FQN="clang::threadSafety::til::SCFG::setExit", NM="_ZN5clang12threadSafety3til4SCFG7setExitEPNS1_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til4SCFG7setExitEPNS1_10BasicBlockE")
  //</editor-fold>
  public void setExit(BasicBlock /*P*/ BB) {
    Exit = BB;
  }

  
  
  // Normalizes a CFG.  Normalization has a few major components:
  // 1) Removing unreachable blocks.
  // 2) Computing dominators and post-dominators
  // 3) Topologically sorting the blocks into the "Blocks" array.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SCFG::computeNormalForm">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp", line = 294,
   FQN="clang::threadSafety::til::SCFG::computeNormalForm", NM="_ZN5clang12threadSafety3til4SCFG17computeNormalFormEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til4SCFG17computeNormalFormEv")
  //</editor-fold>
  public void computeNormalForm() {
    // Topologically sort the blocks starting from the entry block.
    int NumUnreachableBlocks = Entry.topologicalSort(Blocks, Blocks.size());
    if (NumUnreachableBlocks > 0) {
      // If there were unreachable blocks shift everything down, and delete them.
      for (/*size_t*/int I = NumUnreachableBlocks, E = Blocks.size(); $less_uint(I, E); ++I) {
        /*size_t*/int NI = I - NumUnreachableBlocks;
        Blocks.$set(NI, Blocks.$at(I));
        Blocks.$at(NI).BlockID = NI;
        // FIXME: clean up predecessor pointers to unreachable blocks?
      }
      Blocks.drop(NumUnreachableBlocks);
    }
    
    // Compute dominators.
    for (BasicBlock /*P*/ Block : Blocks)  {
      Block.computeDominator();
    }
    
    // Once dominators have been computed, the final sort may be performed.
    int NumBlocks = Exit.topologicalFinalSort(Blocks, 0);
    assert (((/*static_cast*//*size_t*/int)(NumBlocks)) == Blocks.size());
    ///*J:(void)*/NumBlocks;
    
    // Renumber the instructions now that we have a final sort.
    renumberInstrs();
    
    // Compute post-dominators and compute the sizes of each node in the
    // dominator tree.
    for (BasicBlock /*P*/ Block : Blocks.reverse()) {
      Block.computePostDominator();
      computeNodeSize(Block, /*AddrOf*/(BasicBlock B)->{return B.DominatorNode;});
    }
    // Compute the sizes of each node in the post-dominator tree and assign IDs in
    // the dominator tree.
    for (BasicBlock /*P*/ Block : Blocks) {
      computeNodeID(Block, /*AddrOf*/(BasicBlock B)->{return B.DominatorNode;});
      computeNodeSize(Block, /*AddrOf*/(BasicBlock B)->{return B.PostDominatorNode;});
    }
    // Assign IDs in the post-dominator tree.
    for (BasicBlock /*P*/ Block : Blocks.reverse()) {
      computeNodeID(Block, /*AddrOf*/(BasicBlock B)->{return B.PostDominatorNode;});
    }
  }

  
  /*template <class V> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SCFG::traverse">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1755,
   FQN="clang::threadSafety::til::SCFG::traverse", NM="Tpl__ZN5clang12threadSafety3til4SCFG8traverseERT_NS3_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZN5clang12threadSafety3til4SCFG8traverseERT_NS3_5R_CtxE")
  //</editor-fold>
  public </*class*/ V extends VisitReducer> boolean/*V.R_SExpr*/ traverse(final V /*&*/ Vs, SimpleReducerBase.TraversalKind/*V.R_Ctx*/ Ctx) {
    Vs.enterCFG(/*Deref*/this);
     VisitReducer.Container<BasicBlock /*P*/ > Bbs/*J*/= /*ParenList*/new  VisitReducer.Container<BasicBlock /*P*/ >(Vs, Blocks.size());
    
    for (BasicBlock /*P*/ B : Blocks) {
      Bbs.push_back(B.traverse(Vs, Vs.subExprCtx(Ctx)));
    }
    Vs.exitCFG(/*Deref*/this);
    return Vs.reduceSCFG(/*Deref*/this, Bbs);
  }

  
  /*template <class C> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SCFG::compare">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1767,
   FQN="clang::threadSafety::til::SCFG::compare", NM="Tpl__ZNK5clang12threadSafety3til4SCFG7compareEPKS2_RT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZNK5clang12threadSafety3til4SCFG7compareEPKS2_RT_")
  //</editor-fold>
  public </*class*/ C extends Comparator<?>> boolean/*C.CType*/ compare(/*const*/ SCFG /*P*/ E, final C /*&*/ Cmp) /*const*/ {
    // TODO: implement CFG comparisons
    return Cmp.comparePointers(this, E);
  }

/*private:*/
  
  // Renumber instructions in all blocks
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SCFG::renumberInstrs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp", line = 262,
   FQN="clang::threadSafety::til::SCFG::renumberInstrs", NM="_ZN5clang12threadSafety3til4SCFG14renumberInstrsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til4SCFG14renumberInstrsEv")
  //</editor-fold>
  private void renumberInstrs() {
    int InstrID = 0;
    for (BasicBlock /*P*/ Block : Blocks)  {
      InstrID = Block.renumberInstrs(InstrID);
    }
  }
 // assign unique ids to all instructions
/*private:*/
  private MemRegionRef Arena;
  private SimpleArray<BasicBlock /*P*/ > Blocks;
  private BasicBlock /*P*/ Entry;
  private BasicBlock /*P*/ Exit;
  private /*uint*/int NumInstructions;
  private boolean Normal;
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public java.util.Iterator<BasicBlock> iterator() { return new JavaIterator<>(begin(), end()); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Arena=" + Arena // NOI18N
              + ", Blocks=" + Blocks // NOI18N
              + ", Entry=" + Entry // NOI18N
              + ", Exit=" + Exit // NOI18N
              + ", NumInstructions=" + NumInstructions // NOI18N
              + ", Normal=" + Normal // NOI18N
              + super.toString(); // NOI18N
  }
}
