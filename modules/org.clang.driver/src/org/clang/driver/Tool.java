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

package org.clang.driver;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.impl.*;
import org.llvm.support.sys.*;


/// Tool - Information on a specific compilation tool.
//<editor-fold defaultstate="collapsed" desc="clang::driver::Tool">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Tool.h", line = 34,
 FQN="clang::driver::Tool", NM="_ZN5clang6driver4ToolE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tool.cpp -nm=_ZN5clang6driver4ToolE")
//</editor-fold>
public abstract class Tool implements Destructors.ClassWithDestructor {
/*public:*/
  // Documents the level of support for response files in this tool.
  // Response files are necessary if the command line gets too large,
  // requiring the arguments to be transfered to a file.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Tool::ResponseFileSupport">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Tool.h", line = 39,
   FQN="clang::driver::Tool::ResponseFileSupport", NM="_ZN5clang6driver4Tool19ResponseFileSupportE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tool.cpp -nm=_ZN5clang6driver4Tool19ResponseFileSupportE")
  //</editor-fold>
  public enum ResponseFileSupport {
    // Provides full support for response files, which means we can transfer
    // all tool input arguments to a file. E.g.: clang, gcc, binutils and MSVC
    // tools.
    RF_Full(0),
    // Input file names can live in a file, but flags can't. E.g.: ld64 (Mac
    // OS X linker).
    RF_FileList(RF_Full.getValue() + 1),
    // Does not support response files: all arguments must be passed via
    // command line.
    RF_None(RF_FileList.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ResponseFileSupport valueOf(int val) {
      ResponseFileSupport out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      return out;
    }

    private static final class Values {
      private static final ResponseFileSupport[] VALUES;
      private static final ResponseFileSupport[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ResponseFileSupport kind : ResponseFileSupport.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ResponseFileSupport[min < 0 ? (1-min) : 0];
        VALUES = new ResponseFileSupport[max >= 0 ? (1+max) : 0];
        for (ResponseFileSupport kind : ResponseFileSupport.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final int value;
    private ResponseFileSupport(/*uint*/int val) { this.value = (int)val;}
    public int getValue() { return (int)value;}
    //</editor-fold>
  };
/*private:*/
  /// The tool name (for debugging).
  private /*const*/char$ptr/*char P*/ Name;
  
  /// The human readable name for the tool, for use in diagnostics.
  private /*const*/char$ptr/*char P*/ ShortName;
  
  /// The tool chain this tool is a part of.
  private /*const*/ ToolChain /*&*/ TheToolChain;
  
  /// The level of support for response files seen in this tool
  private /*const*/ ResponseFileSupport ResponseSupport;
  
  /// The encoding to use when writing response files for this tool on Windows
  private /*const*/ WindowsEncodingMethod ResponseEncoding;
  
  /// The flag used to pass a response file via command line to this tool
  private /*const*/char$ptr/*char P*//*const*/ ResponseFlag;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Tool::Tool">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tool.cpp", line = 14,
   FQN = "clang::driver::Tool::Tool", NM = "_ZN5clang6driver4ToolC1EPKcS3_RKNS0_9ToolChainENS1_19ResponseFileSupportEN4llvm3sys21WindowsEncodingMethodES3_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tool.cpp -nm=_ZN5clang6driver4ToolC1EPKcS3_RKNS0_9ToolChainENS1_19ResponseFileSupportEN4llvm3sys21WindowsEncodingMethodES3_")
  //</editor-fold>
  public Tool(/*const*/char$ptr/*char P*/ _Name, /*const*/char$ptr/*char P*/ _ShortName, /*const*/ ToolChain /*&*/ TC) {
    this(_Name, _ShortName, TC, 
      ResponseFileSupport.RF_None, 
      WindowsEncodingMethod.WEM_UTF8, 
      $("@"));
  }
  public Tool(/*const*/char$ptr/*char P*/ _Name, /*const*/char$ptr/*char P*/ _ShortName, /*const*/ ToolChain /*&*/ TC, 
      ResponseFileSupport _ResponseSupport/*= RF_None*/) {
    this(_Name, _ShortName, TC, 
      _ResponseSupport, 
      WindowsEncodingMethod.WEM_UTF8, 
      $("@"));
  }
  public Tool(/*const*/char$ptr/*char P*/ _Name, /*const*/char$ptr/*char P*/ _ShortName, /*const*/ ToolChain /*&*/ TC, 
      ResponseFileSupport _ResponseSupport/*= RF_None*/, 
      WindowsEncodingMethod _ResponseEncoding/*= sys::WEM_UTF8*/) {
    this(_Name, _ShortName, TC, 
      _ResponseSupport, 
      _ResponseEncoding, 
      $("@"));
  }
  public Tool(/*const*/char$ptr/*char P*/ _Name, /*const*/char$ptr/*char P*/ _ShortName, /*const*/ ToolChain /*&*/ TC, 
      ResponseFileSupport _ResponseSupport/*= RF_None*/, 
      WindowsEncodingMethod _ResponseEncoding/*= sys::WEM_UTF8*/, 
      /*const*/char$ptr/*char P*/ _ResponseFlag/*= "@"*/) {
    /* : Name(_Name), ShortName(_ShortName), TheToolChain(TC), ResponseSupport(_ResponseSupport), ResponseEncoding(_ResponseEncoding), ResponseFlag(_ResponseFlag)*/ 
    //START JInit
    this.Name = $tryClone(_Name);
    this.ShortName = $tryClone(_ShortName);
    this.TheToolChain = TC;
    this.ResponseSupport = _ResponseSupport;
    this.ResponseEncoding = _ResponseEncoding;
    this.ResponseFlag = $tryClone(_ResponseFlag);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Tool::~Tool">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tool.cpp", line = 22,
   FQN = "clang::driver::Tool::~Tool", NM = "_ZN5clang6driver4ToolD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tool.cpp -nm=_ZN5clang6driver4ToolD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Tool::getName">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Tool.h", line = 80,
   FQN = "clang::driver::Tool::getName", NM = "_ZNK5clang6driver4Tool7getNameEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tool.cpp -nm=_ZNK5clang6driver4Tool7getNameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getName() /*const*/ {
    return Name;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Tool::getShortName">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Tool.h", line = 82,
   FQN = "clang::driver::Tool::getShortName", NM = "_ZNK5clang6driver4Tool12getShortNameEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tool.cpp -nm=_ZNK5clang6driver4Tool12getShortNameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getShortName() /*const*/ {
    return ShortName;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Tool::getToolChain">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Tool.h", line = 84,
   FQN = "clang::driver::Tool::getToolChain", NM = "_ZNK5clang6driver4Tool12getToolChainEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tool.cpp -nm=_ZNK5clang6driver4Tool12getToolChainEv")
  //</editor-fold>
  public /*const*/ ToolChain /*&*/ getToolChain() /*const*/ {
    return TheToolChain;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Tool::hasIntegratedAssembler">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Tool.h", line = 86,
   FQN = "clang::driver::Tool::hasIntegratedAssembler", NM = "_ZNK5clang6driver4Tool22hasIntegratedAssemblerEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tool.cpp -nm=_ZNK5clang6driver4Tool22hasIntegratedAssemblerEv")
  //</editor-fold>
  public /*virtual*/ boolean hasIntegratedAssembler() /*const*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Tool::canEmitIR">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Tool.h", line = 87,
   FQN = "clang::driver::Tool::canEmitIR", NM = "_ZNK5clang6driver4Tool9canEmitIREv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tool.cpp -nm=_ZNK5clang6driver4Tool9canEmitIREv")
  //</editor-fold>
  public /*virtual*/ boolean canEmitIR() /*const*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Tool::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Tool.h", line = 88,
   FQN = "clang::driver::Tool::hasIntegratedCPP", NM = "_ZNK5clang6driver4Tool16hasIntegratedCPPEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tool.cpp -nm=_ZNK5clang6driver4Tool16hasIntegratedCPPEv")
  //</editor-fold>
  public abstract /*virtual*/ boolean hasIntegratedCPP() /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Tool::isLinkJob">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Tool.h", line = 89,
   FQN = "clang::driver::Tool::isLinkJob", NM = "_ZNK5clang6driver4Tool9isLinkJobEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tool.cpp -nm=_ZNK5clang6driver4Tool9isLinkJobEv")
  //</editor-fold>
  public /*virtual*/ boolean isLinkJob() /*const*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Tool::isDsymutilJob">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Tool.h", line = 90,
   FQN = "clang::driver::Tool::isDsymutilJob", NM = "_ZNK5clang6driver4Tool13isDsymutilJobEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tool.cpp -nm=_ZNK5clang6driver4Tool13isDsymutilJobEv")
  //</editor-fold>
  public /*virtual*/ boolean isDsymutilJob() /*const*/ {
    return false;
  }

  /// \brief Returns the level of support for response files of this tool,
  /// whether it accepts arguments to be passed via a file on disk.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Tool::getResponseFilesSupport">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Tool.h", line = 93,
   FQN = "clang::driver::Tool::getResponseFilesSupport", NM = "_ZNK5clang6driver4Tool23getResponseFilesSupportEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tool.cpp -nm=_ZNK5clang6driver4Tool23getResponseFilesSupportEv")
  //</editor-fold>
  public ResponseFileSupport getResponseFilesSupport() /*const*/ {
    return ResponseSupport;
  }

  /// \brief Returns which encoding the response file should use. This is only
  /// relevant on Windows platforms where there are different encodings being
  /// accepted for different tools. On UNIX, UTF8 is universal.
  ///
  /// Windows use cases: - GCC and Binutils on mingw only accept ANSI response
  /// files encoded with the system current code page.
  /// - MSVC's CL.exe and LINK.exe accept UTF16 on Windows.
  /// - Clang accepts both UTF8 and UTF16.
  ///
  /// FIXME: When GNU tools learn how to parse UTF16 on Windows, we should
  /// always use UTF16 for Windows, which is the Windows official encoding for
  /// international characters.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Tool::getResponseFileEncoding">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Tool.h", line = 108,
   FQN = "clang::driver::Tool::getResponseFileEncoding", NM = "_ZNK5clang6driver4Tool23getResponseFileEncodingEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tool.cpp -nm=_ZNK5clang6driver4Tool23getResponseFileEncodingEv")
  //</editor-fold>
  public WindowsEncodingMethod getResponseFileEncoding() /*const*/ {
    return ResponseEncoding;
  }

  /// \brief Returns which prefix to use when passing the name of a response
  /// file as a parameter to this tool.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Tool::getResponseFileFlag">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Tool.h", line = 113,
   FQN = "clang::driver::Tool::getResponseFileFlag", NM = "_ZNK5clang6driver4Tool19getResponseFileFlagEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tool.cpp -nm=_ZNK5clang6driver4Tool19getResponseFileFlagEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getResponseFileFlag() /*const*/ {
    return ResponseFlag;
  }

  
  /// \brief Does this tool have "good" standardized diagnostics, or should the
  /// driver add an additional "command failed" diagnostic on failures.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Tool::hasGoodDiagnostics">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Tool.h", line = 117,
   FQN = "clang::driver::Tool::hasGoodDiagnostics", NM = "_ZNK5clang6driver4Tool18hasGoodDiagnosticsEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tool.cpp -nm=_ZNK5clang6driver4Tool18hasGoodDiagnosticsEv")
  //</editor-fold>
  public /*virtual*/ boolean hasGoodDiagnostics() /*const*/ {
    return false;
  }

  
  /// ConstructJob - Construct jobs to perform the action \p JA,
  /// writing to \p Output and with \p Inputs, and add the jobs to
  /// \p C.
  ///
  /// \param TCArgs - The argument list for this toolchain, with any
  /// tool chain specific translations applied.
  /// \param LinkingOutput - If this output will eventually feed the
  /// linker, then this is the final output name of the linked image.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Tool::ConstructJob">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Tool.h", line = 127,
   FQN = "clang::driver::Tool::ConstructJob", NM = "_ZNK5clang6driver4Tool12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS7_Lj4EEERKNSA_3opt7ArgListEPKc",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tool.cpp -nm=_ZNK5clang6driver4Tool12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS7_Lj4EEERKNSA_3opt7ArgListEPKc")
  //</editor-fold>
  public abstract /*virtual*/ void ConstructJob(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, 
              /*const*/ InputInfo /*&*/ Output, 
              /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
              /*const*/ ArgList /*&*/ TCArgs, 
              /*const*/char$ptr/*char P*/ LinkingOutput) /*const*//* = 0*/;

  
  public String toString() {
    return "" + "Name=" + Name // NOI18N
              + ", ShortName=" + ShortName // NOI18N
              + ", TheToolChain=" + TheToolChain // NOI18N
              + ", ResponseSupport=" + ResponseSupport // NOI18N
              + ", ResponseEncoding=" + ResponseEncoding // NOI18N
              + ", ResponseFlag=" + ResponseFlag; // NOI18N
  }
}
