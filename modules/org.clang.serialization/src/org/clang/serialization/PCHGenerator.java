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

package org.clang.serialization;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.sema.*;
import org.llvm.bitcode.*;
import org.clang.serialization.spi.PCHBufferBase;


/// \brief AST and semantic-analysis consumer that generates a
/// precompiled header from the parsed source code.
//<editor-fold defaultstate="collapsed" desc="clang::PCHGenerator">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 911,
 FQN="clang::PCHGenerator", NM="_ZN5clang12PCHGeneratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GeneratePCH.cpp -nm=_ZN5clang12PCHGeneratorE")
//</editor-fold>
public class PCHGenerator extends /*public*/ SemaConsumer implements Destructors.ClassWithDestructor {
  private final /*const*/ Preprocessor /*&*/ PP;
  private std.string OutputFile;
  private Module /*P*/ Module;
  private std.string isysroot;
  private Sema /*P*/ SemaPtr;
  private std.shared_ptr<? extends PCHBufferBase> Buffer;
  private BitstreamWriter Stream;
  private ASTWriter Writer;
  private boolean AllowASTWithErrors;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PCHGenerator::getWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 923,
   FQN="clang::PCHGenerator::getWriter", NM="_ZN5clang12PCHGenerator9getWriterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GeneratePCH.cpp -nm=_ZN5clang12PCHGenerator9getWriterEv")
  //</editor-fold>
  protected ASTWriter /*&*/ getWriter() {
    return Writer;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PCHGenerator::getWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 924,
   FQN="clang::PCHGenerator::getWriter", NM="_ZNK5clang12PCHGenerator9getWriterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GeneratePCH.cpp -nm=_ZNK5clang12PCHGenerator9getWriterEv")
  //</editor-fold>
  protected /*const*/ ASTWriter /*&*/ getWriter$Const() /*const*/ {
    return Writer;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PCHGenerator::getPCH">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 925,
   FQN="clang::PCHGenerator::getPCH", NM="_ZNK5clang12PCHGenerator6getPCHEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GeneratePCH.cpp -nm=_ZNK5clang12PCHGenerator6getPCHEv")
  //</editor-fold>
  protected SmallString/*&*/ getPCH() /*const*/ {
    return Buffer.$arrow().Data;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PCHGenerator::PCHGenerator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GeneratePCH.cpp", line = 26,
   FQN="clang::PCHGenerator::PCHGenerator", NM="_ZN5clang12PCHGeneratorC1ERKNS_12PreprocessorEN4llvm9StringRefEPNS_6ModuleES5_St10shared_ptrINS_9PCHBufferEENS4_8ArrayRefINS4_18IntrusiveRefCntPtrINS_19ModuleFileExtensionEEEEEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GeneratePCH.cpp -nm=_ZN5clang12PCHGeneratorC1ERKNS_12PreprocessorEN4llvm9StringRefEPNS_6ModuleES5_St10shared_ptrINS_9PCHBufferEENS4_8ArrayRefINS4_18IntrusiveRefCntPtrINS_19ModuleFileExtensionEEEEEbb")
  //</editor-fold>
  public PCHGenerator(final /*const*/ Preprocessor /*&*/ PP, StringRef OutputFile, 
      Module /*P*/ $Module, StringRef isysroot, 
      std.shared_ptr<? extends PCHBufferBase> Buffer, 
      ArrayRef<IntrusiveRefCntPtr<ModuleFileExtension>> Extensions) {
    this(PP, OutputFile, 
      $Module, isysroot, 
      Buffer, 
      Extensions, 
      false, true);
  }
  public PCHGenerator(final /*const*/ Preprocessor /*&*/ PP, StringRef OutputFile, 
      Module /*P*/ $Module, StringRef isysroot, 
      std.shared_ptr<? extends PCHBufferBase> Buffer, 
      ArrayRef<IntrusiveRefCntPtr<ModuleFileExtension>> Extensions, 
      boolean AllowASTWithErrors/*= false*/) {
    this(PP, OutputFile, 
      $Module, isysroot, 
      Buffer, 
      Extensions, 
      AllowASTWithErrors, true);
  }
  public PCHGenerator(final /*const*/ Preprocessor /*&*/ PP, StringRef OutputFile, 
      Module /*P*/ $Module, StringRef isysroot, 
      std.shared_ptr<? extends PCHBufferBase> Buffer, 
      ArrayRef<IntrusiveRefCntPtr<ModuleFileExtension>> Extensions, 
      boolean AllowASTWithErrors/*= false*/, boolean IncludeTimestamps/*= true*/) {
    // : SemaConsumer(), PP(PP), OutputFile(OutputFile.operator basic_string()), Module(Module), isysroot(isysroot.str()), SemaPtr(null), Buffer(Buffer), Stream(Buffer->Data), Writer(Stream, Extensions, IncludeTimestamps), AllowASTWithErrors(AllowASTWithErrors) 
    //START JInit
    super();
    this./*&*/PP=/*&*/PP;
    this.OutputFile = OutputFile.$string();
    this.Module = $Module;
    this.isysroot = isysroot.str();
    this.SemaPtr = null;
    this.Buffer = new std.shared_ptr(Buffer);
    this.Stream = new BitstreamWriter(Buffer.$arrow().Data);
    this.Writer = new ASTWriter(Stream, new ArrayRef<IntrusiveRefCntPtr<ModuleFileExtension>>(Extensions), IncludeTimestamps);
    this.AllowASTWithErrors = AllowASTWithErrors;
    //END JInit
    Buffer.$arrow().IsComplete = false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PCHGenerator::~PCHGenerator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GeneratePCH.cpp", line = 39,
   FQN="clang::PCHGenerator::~PCHGenerator", NM="_ZN5clang12PCHGeneratorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GeneratePCH.cpp -nm=_ZN5clang12PCHGeneratorD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    //START JDestroy
    Writer.$destroy();
    Stream.$destroy();
    Buffer.$destroy();
    isysroot.$destroy();
    OutputFile.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PCHGenerator::InitializeSema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 936,
   FQN="clang::PCHGenerator::InitializeSema", NM="_ZN5clang12PCHGenerator14InitializeSemaERNS_4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GeneratePCH.cpp -nm=_ZN5clang12PCHGenerator14InitializeSemaERNS_4SemaE")
  //</editor-fold>
  @Override public void InitializeSema(final Sema /*&*/ S)/* override*/ {
    SemaPtr = $AddrOf(S);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PCHGenerator::HandleTranslationUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GeneratePCH.cpp", line = 42,
   FQN="clang::PCHGenerator::HandleTranslationUnit", NM="_ZN5clang12PCHGenerator21HandleTranslationUnitERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GeneratePCH.cpp -nm=_ZN5clang12PCHGenerator21HandleTranslationUnitERNS_10ASTContextE")
  //</editor-fold>
  @Override public void HandleTranslationUnit(final ASTContext /*&*/ Ctx)/* override*/ {
    // Don't create a PCH if there were fatal failures during module loading.
    if (PP.getModuleLoader().HadFatalFailure) {
      return;
    }
    
    boolean hasErrors = PP.getDiagnostics().hasErrorOccurred();
    if (hasErrors && !AllowASTWithErrors) {
      return;
    }
    
    // Emit the PCH file to the Buffer.
    assert ((SemaPtr != null)) : "No Sema?";
    Buffer.$arrow().Signature
       = Writer.WriteAST($Deref(SemaPtr), OutputFile, Module, new StringRef(isysroot), 
        // For serialization we are lenient if the errors were
        // only warn-as-error kind.
        PP.getDiagnostics().hasUncompilableErrorOccurred());
    
    Buffer.$arrow().IsComplete = true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PCHGenerator::GetASTMutationListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GeneratePCH.cpp", line = 62,
   FQN="clang::PCHGenerator::GetASTMutationListener", NM="_ZN5clang12PCHGenerator22GetASTMutationListenerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GeneratePCH.cpp -nm=_ZN5clang12PCHGenerator22GetASTMutationListenerEv")
  //</editor-fold>
  @Override public ASTMutationListener /*P*/ GetASTMutationListener()/* override*/ {
    return $AddrOf(Writer);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PCHGenerator::GetASTDeserializationListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GeneratePCH.cpp", line = 66,
   FQN="clang::PCHGenerator::GetASTDeserializationListener", NM="_ZN5clang12PCHGenerator29GetASTDeserializationListenerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GeneratePCH.cpp -nm=_ZN5clang12PCHGenerator29GetASTDeserializationListenerEv")
  //</editor-fold>
  @Override public ASTDeserializationListener /*P*/ GetASTDeserializationListener()/* override*/ {
    return $AddrOf(Writer);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PCHGenerator::hasEmittedPCH">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 940,
   FQN="clang::PCHGenerator::hasEmittedPCH", NM="_ZNK5clang12PCHGenerator13hasEmittedPCHEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GeneratePCH.cpp -nm=_ZNK5clang12PCHGenerator13hasEmittedPCHEv")
  //</editor-fold>
  public boolean hasEmittedPCH() /*const*/ {
    return Buffer.$arrow().IsComplete;
  }

  
  @Override public String toString() {
    return "" + "PP=" + "[Preprocessor]" // NOI18N
              + ", OutputFile=" + OutputFile // NOI18N
              + ", Module=" + Module // NOI18N
              + ", isysroot=" + isysroot // NOI18N
              + ", SemaPtr=" + "[Sema]" // NOI18N
              + ", Buffer=" + Buffer // NOI18N
              + ", Stream=" + Stream // NOI18N
              + ", Writer=" + Writer // NOI18N
              + ", AllowASTWithErrors=" + AllowASTWithErrors // NOI18N
              + super.toString(); // NOI18N
  }
}
