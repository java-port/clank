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
/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2015 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s):
 *
 * Portions Copyrighted 2015 Sun Microsystems, Inc.
 */
package org.clang.lex.java.impl;

import org.clang.basic.CharSourceRange;
import org.clang.basic.SourceLocation;
import org.clang.lex.DirectoryLookup;
import org.clang.lex.Token;
import static org.clank.support.NativePointer.create_char$null$ptr;
import static org.clank.support.NativePointer.create_type$ref;
import org.llvm.adt.SmallString;
import org.llvm.adt.StringRef;
import org.clank.support.aliases.*;
/**
 *
 * @author Vladimir Voskresensky
 */
public final class HandleIncludeDirectiveHelper {
  private final Token FilenameToken = new Token();
  private final SourceLocation End = new SourceLocation();
  private final SourceLocation FilenameTokLocation = new SourceLocation();
  private final CharSourceRange FilenameRange = CharSourceRange.getCharRange(SourceLocation.getInvalid(), SourceLocation.getInvalid());
  private final StringRef Filename = new StringRef();
  private final StringRef OriginalFilename = new StringRef();
  private final type$ref<type$ptr<DirectoryLookup>> CurDir = create_type$ref(null);
  private final SmallString FilenameBuffer = new SmallString(128);
  private final SmallString SearchPath = new SmallString(1024);
  private final SmallString RelativePath = new SmallString(1024);
  private final SmallString NormalizedPath = new SmallString(128);
  private final SmallString RecoveryPath = new SmallString(128);
  private final SmallString PathString = new SmallString(128);
  
  private final StringRef SearchPathStringRef = new StringRef(create_char$null$ptr(), 0);
  private final StringRef RelativePathStringRef = new StringRef(create_char$null$ptr(), 0);
  private final StringRef NormalizedPathStringRef = new StringRef(create_char$null$ptr(), 0);
  private final StringRef RecoveryPathStringRef = new StringRef(create_char$null$ptr(), 0);
  
  public void release() {
    this.FilenameToken.$destroy();
    this.Filename.$assign(StringRef.R$EMPTY);
    this.OriginalFilename.$assign(StringRef.R$EMPTY);
    this.CurDir.$set(null);
    this.FilenameBuffer.set_size(0);
    this.SearchPath.set_size(0);
    this.RelativePath.set_size(0);
    this.NormalizedPath.set_size(0);
    this.RecoveryPath.set_size(0);
    this.PathString.set_size(0);
    // do not clean up to keep Data field pointing to corresponding SmallString buffers
//    this.SearchPathStringRef.$destroy();
//    this.RelativePathStringRef.$destroy();
//    this.NormalizedPathStringRef.$destroy();
//    this.RecoveryPathStringRef.$destroy();
  }
  
  public type$ref<type$ptr<DirectoryLookup>> $CurDir() {
    return CurDir;
  }
  
  public SourceLocation $End() {
    return End.$assign(SourceLocation.getInvalid());
  }
  
  public SourceLocation $FilenameTokLocation(/*SourceLocation*/int rawLoc) {
    return FilenameTokLocation.$assign(rawLoc);
  }
  
  public CharSourceRange $getFilenameRange(/*SourceLocation*/int rawLocB, /*SourceLocation*/int rawLocE) {
    FilenameRange.setBegin(rawLocB);
    FilenameRange.setEnd(rawLocE);
    return FilenameRange;
  }
  
  public StringRef $OriginalFilename(StringRef Filename) {
    OriginalFilename.$assign(Filename);
    return OriginalFilename;
  }
  
  public StringRef $Filename() {
    return Filename;
  }
  
  public Token $FilenameToken() {
    return FilenameToken;
  }
  
  public SmallString $FilenameBuffer() {
    return FilenameBuffer;
  }
  
  public SmallString $SearchPath() {
    return SearchPath;
  }

  public SmallString $RelativePath() {
    return RelativePath;
  }
  
  public SmallString $NormalizedPath() {
    return NormalizedPath;
  }

  public SmallString $RecoveryPath() {
    return RecoveryPath;
  }

  public SmallString $PathString() {
    return PathString;
  }
  
  public StringRef $SearchPathStringRef(SmallString path) {
    assert path == SearchPath;
    return SearchPathStringRef.$assign(path);
  }

  public StringRef $RelativePathStringRef(SmallString path) {
    assert path == RelativePath;
    return RelativePathStringRef.$assign(path);
  }

  public StringRef $NormalizedPathStringRef(SmallString path) {
    assert path == NormalizedPath;
    return NormalizedPathStringRef.$assign(path);
  }  

  public StringRef $RecoveryPathStringRef(SmallString path) {
    assert path == RecoveryPath;
    return RecoveryPathStringRef.$assign(path);
  }  
}
