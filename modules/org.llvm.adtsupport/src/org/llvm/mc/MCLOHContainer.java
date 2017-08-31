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

package org.llvm.mc;

import org.clank.support.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;

//<editor-fold defaultstate="collapsed" desc="llvm::MCLOHContainer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 134,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", old_line = 153,
 FQN="llvm::MCLOHContainer", NM="_ZN4llvm14MCLOHContainerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm14MCLOHContainerE")
//</editor-fold>
public class MCLOHContainer implements Destructors.ClassWithDestructor {
  /// Keep track of the emit size of all the LOHs.
  private /*mutable */long/*uint64_t*/ EmitSize;
  
  /// Keep track of all LOH directives.
  private SmallVector<MCLOHDirective> Directives;
/*public:*/
  // JAVA: typedef SmallVectorImpl<MCLOHDirective> LOHDirectives
//  public final class LOHDirectives extends SmallVectorImpl<MCLOHDirective>{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCLOHContainer::MCLOHContainer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 144,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", old_line = 163,
   FQN="llvm::MCLOHContainer::MCLOHContainer", NM="_ZN4llvm14MCLOHContainerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm14MCLOHContainerC1Ev")
  //</editor-fold>
  public MCLOHContainer() {
    // : EmitSize(0), Directives() 
    //START JInit
    this.EmitSize = $int2ulong(0);
    this.Directives = new SmallVector<MCLOHDirective>(32, new MCLOHDirective());
    //END JInit
  }

  
  /// Const accessor to the directives.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCLOHContainer::getDirectives">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 147,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", old_line = 166,
   FQN="llvm::MCLOHContainer::getDirectives", NM="_ZNK4llvm14MCLOHContainer13getDirectivesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm14MCLOHContainer13getDirectivesEv")
  //</editor-fold>
  public /*const*/ SmallVectorImpl<MCLOHDirective> /*&*/ getDirectives() /*const*/ {
    return Directives;
  }

  
  /// Add the directive of the given kind \p Kind with the given arguments
  /// \p Args to the container.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCLOHContainer::addDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 153,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", old_line = 172,
   FQN="llvm::MCLOHContainer::addDirective", NM="_ZN4llvm14MCLOHContainer12addDirectiveENS_9MCLOHTypeERKNS_15SmallVectorImplIPNS_8MCSymbolEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm14MCLOHContainer12addDirectiveENS_9MCLOHTypeERKNS_15SmallVectorImplIPNS_8MCSymbolEEE")
  //</editor-fold>
  public void addDirective(/*MCLOHType*//*uint*/int Kind, final /*const*/ SmallVectorImpl<MCSymbol /*P*/ > /*&*/ Args) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Directives.push_back_T$RR($c$.track(new MCLOHDirective(Kind, Args))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Get the size of the directives if emitted.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCLOHContainer::getEmitSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 158,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", old_line = 177,
   FQN="llvm::MCLOHContainer::getEmitSize", NM="_ZNK4llvm14MCLOHContainer11getEmitSizeERKNS_16MachObjectWriterERKNS_11MCAsmLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm14MCLOHContainer11getEmitSizeERKNS_16MachObjectWriterERKNS_11MCAsmLayoutE")
  //</editor-fold>
  public long/*uint64_t*/ getEmitSize(final /*const*/ MachObjectWriter /*&*/ ObjWriter, 
             final /*const*/ MCAsmLayout /*&*/ Layout) /*const*/ {
    if (!(EmitSize != 0)) {
      for (final /*const*/ MCLOHDirective /*&*/ D : Directives)  {
        EmitSize += D.getEmitSize(ObjWriter, Layout);
      }
    }
    return EmitSize;
  }

  
  /// Emit all Linker Optimization Hint in one big table.
  /// Each line of the table is emitted by LOHDirective::emit.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCLOHContainer::emit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 169,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", old_line = 188,
   FQN="llvm::MCLOHContainer::emit", NM="_ZNK4llvm14MCLOHContainer4emitERNS_16MachObjectWriterERKNS_11MCAsmLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm14MCLOHContainer4emitERNS_16MachObjectWriterERKNS_11MCAsmLayoutE")
  //</editor-fold>
  public void emit(final MachObjectWriter /*&*/ ObjWriter, final /*const*/ MCAsmLayout /*&*/ Layout) /*const*/ {
    for (final /*const*/ MCLOHDirective /*&*/ D : Directives)  {
      D.emit(ObjWriter, Layout);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCLOHContainer::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 174,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", old_line = 193,
   FQN="llvm::MCLOHContainer::reset", NM="_ZN4llvm14MCLOHContainer5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm14MCLOHContainer5resetEv")
  //</editor-fold>
  public void reset() {
    Directives.clear();
    EmitSize = $int2ulong(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCLOHContainer::~MCLOHContainer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 134,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", old_line = 153,
   FQN="llvm::MCLOHContainer::~MCLOHContainer", NM="_ZN4llvm14MCLOHContainerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm14MCLOHContainerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Directives.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "EmitSize=" + EmitSize // NOI18N
              + ", Directives=" + Directives; // NOI18N
  }
}
