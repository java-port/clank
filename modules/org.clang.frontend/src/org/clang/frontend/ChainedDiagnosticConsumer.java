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

package org.clang.frontend;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.basic.*;
import org.clang.basic.spi.PreprocessorImplementation;


/// ChainedDiagnosticConsumer - Chain two diagnostic clients so that diagnostics
/// go to the first client and then the second. The first diagnostic client
/// should be the "primary" client, and will be used for computing whether the
/// diagnostics should be included in counts.
//<editor-fold defaultstate="collapsed" desc="clang::ChainedDiagnosticConsumer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ChainedDiagnosticConsumer.h", line = 23,
 FQN="clang::ChainedDiagnosticConsumer", NM="_ZN5clang25ChainedDiagnosticConsumerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedDiagnosticConsumer.cpp -nm=_ZN5clang25ChainedDiagnosticConsumerE")
//</editor-fold>
public class ChainedDiagnosticConsumer extends /*public*/ DiagnosticConsumer implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::ChainedDiagnosticConsumer::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedDiagnosticConsumer.cpp", line = 14,
   FQN="clang::ChainedDiagnosticConsumer::anchor", NM="_ZN5clang25ChainedDiagnosticConsumer6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedDiagnosticConsumer.cpp -nm=_ZN5clang25ChainedDiagnosticConsumer6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

  private std.unique_ptr<DiagnosticConsumer> OwningPrimary;
  private DiagnosticConsumer /*P*/ Primary;
  private std.unique_ptr<DiagnosticConsumer> Secondary;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ChainedDiagnosticConsumer::ChainedDiagnosticConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ChainedDiagnosticConsumer.h", line = 30,
   FQN="clang::ChainedDiagnosticConsumer::ChainedDiagnosticConsumer", NM="_ZN5clang25ChainedDiagnosticConsumerC1ESt10unique_ptrINS_18DiagnosticConsumerESt14default_deleteIS2_EES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedDiagnosticConsumer.cpp -nm=_ZN5clang25ChainedDiagnosticConsumerC1ESt10unique_ptrINS_18DiagnosticConsumerESt14default_deleteIS2_EES5_")
  //</editor-fold>
  public ChainedDiagnosticConsumer(std.unique_ptr<DiagnosticConsumer> Primary, 
      std.unique_ptr<DiagnosticConsumer> Secondary) {
    // : DiagnosticConsumer(), OwningPrimary(std::move(Primary)), Primary(OwningPrimary.get()), Secondary(std::move(Secondary)) 
    //START JInit
    super();
    this.OwningPrimary = new std.unique_ptr<DiagnosticConsumer>(JD$Move.INSTANCE, std.move(Primary));
    this.Primary = OwningPrimary.get();
    this.Secondary = new std.unique_ptr<DiagnosticConsumer>(JD$Move.INSTANCE, std.move(Secondary));
    //END JInit
  }

  
  /// \brief Construct without taking ownership of \c Primary.
  //<editor-fold defaultstate="collapsed" desc="clang::ChainedDiagnosticConsumer::ChainedDiagnosticConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ChainedDiagnosticConsumer.h", line = 36,
   FQN="clang::ChainedDiagnosticConsumer::ChainedDiagnosticConsumer", NM="_ZN5clang25ChainedDiagnosticConsumerC1EPNS_18DiagnosticConsumerESt10unique_ptrIS1_St14default_deleteIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedDiagnosticConsumer.cpp -nm=_ZN5clang25ChainedDiagnosticConsumerC1EPNS_18DiagnosticConsumerESt10unique_ptrIS1_St14default_deleteIS1_EE")
  //</editor-fold>
  public ChainedDiagnosticConsumer(DiagnosticConsumer /*P*/ Primary, 
      std.unique_ptr<DiagnosticConsumer> Secondary) {
    // : DiagnosticConsumer(), OwningPrimary(), Primary(Primary), Secondary(std::move(Secondary)) 
    //START JInit
    super();
    this.OwningPrimary = new std.unique_ptr<DiagnosticConsumer>();
    this.Primary = Primary;
    this.Secondary = new std.unique_ptr<DiagnosticConsumer>(JD$Move.INSTANCE, std.move(Secondary));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ChainedDiagnosticConsumer::BeginSourceFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ChainedDiagnosticConsumer.h", line = 40,
   FQN="clang::ChainedDiagnosticConsumer::BeginSourceFile", NM="_ZN5clang25ChainedDiagnosticConsumer15BeginSourceFileERKNS_11LangOptionsEPKNS_12PreprocessorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedDiagnosticConsumer.cpp -nm=_ZN5clang25ChainedDiagnosticConsumer15BeginSourceFileERKNS_11LangOptionsEPKNS_12PreprocessorE")
  //</editor-fold>
  @Override public void BeginSourceFile(/*const*/ LangOptions /*&*/ LO, 
                 /*const*/ PreprocessorImplementation /*P*/ PP)/* override*/ {
    Primary.BeginSourceFile(LO, PP);
    Secondary.$arrow().BeginSourceFile(LO, PP);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ChainedDiagnosticConsumer::EndSourceFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ChainedDiagnosticConsumer.h", line = 46,
   FQN="clang::ChainedDiagnosticConsumer::EndSourceFile", NM="_ZN5clang25ChainedDiagnosticConsumer13EndSourceFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedDiagnosticConsumer.cpp -nm=_ZN5clang25ChainedDiagnosticConsumer13EndSourceFileEv")
  //</editor-fold>
  @Override public void EndSourceFile()/* override*/ {
    Secondary.$arrow().EndSourceFile();
    Primary.EndSourceFile();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ChainedDiagnosticConsumer::finish">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ChainedDiagnosticConsumer.h", line = 51,
   FQN="clang::ChainedDiagnosticConsumer::finish", NM="_ZN5clang25ChainedDiagnosticConsumer6finishEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedDiagnosticConsumer.cpp -nm=_ZN5clang25ChainedDiagnosticConsumer6finishEv")
  //</editor-fold>
  @Override public void finish()/* override*/ {
    Secondary.$arrow().finish();
    Primary.finish();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ChainedDiagnosticConsumer::IncludeInDiagnosticCounts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ChainedDiagnosticConsumer.h", line = 56,
   FQN="clang::ChainedDiagnosticConsumer::IncludeInDiagnosticCounts", NM="_ZNK5clang25ChainedDiagnosticConsumer25IncludeInDiagnosticCountsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedDiagnosticConsumer.cpp -nm=_ZNK5clang25ChainedDiagnosticConsumer25IncludeInDiagnosticCountsEv")
  //</editor-fold>
  @Override public boolean IncludeInDiagnosticCounts() /*const*//* override*/ {
    return Primary.IncludeInDiagnosticCounts();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ChainedDiagnosticConsumer::HandleDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ChainedDiagnosticConsumer.h", line = 60,
   FQN="clang::ChainedDiagnosticConsumer::HandleDiagnostic", NM="_ZN5clang25ChainedDiagnosticConsumer16HandleDiagnosticENS_17DiagnosticsEngine5LevelERKNS_10DiagnosticE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedDiagnosticConsumer.cpp -nm=_ZN5clang25ChainedDiagnosticConsumer16HandleDiagnosticENS_17DiagnosticsEngine5LevelERKNS_10DiagnosticE")
  //</editor-fold>
  @Override public void HandleDiagnostic(DiagnosticsEngine.Level DiagLevel, 
                  /*const*/ Diagnostic /*&*/ Info)/* override*/ {
    // Default implementation (Warnings/errors count).
    super.HandleDiagnostic(DiagLevel, Info);
    
    Primary.HandleDiagnostic(DiagLevel, Info);
    Secondary.$arrow().HandleDiagnostic(DiagLevel, Info);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ChainedDiagnosticConsumer::~ChainedDiagnosticConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ChainedDiagnosticConsumer.h", line = 23,
   FQN="clang::ChainedDiagnosticConsumer::~ChainedDiagnosticConsumer", NM="_ZN5clang25ChainedDiagnosticConsumerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedDiagnosticConsumer.cpp -nm=_ZN5clang25ChainedDiagnosticConsumerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Secondary.$destroy();
    OwningPrimary.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "OwningPrimary=" + OwningPrimary // NOI18N
              + ", Primary=" + Primary // NOI18N
              + ", Secondary=" + Secondary // NOI18N
              + super.toString(); // NOI18N
  }
}
